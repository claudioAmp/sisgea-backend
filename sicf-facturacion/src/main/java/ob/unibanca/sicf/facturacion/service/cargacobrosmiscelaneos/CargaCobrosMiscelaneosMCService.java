package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;
import ob.unibanca.sicf.facturacion.model.FacturaMasterCard;
import ob.unibanca.sicf.facturacion.model.MetadataProcedure;
import ob.unibanca.sicf.facturacion.model.resultado.ResultadoCargaFactura;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ob.commons.excel.exception.ReadingExcelFileException;
import ob.commons.excel.util.TypesUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
@Service
public class CargaCobrosMiscelaneosMCService implements ICargaCobrosMiscelaneosMCService {
	
	private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
	private static final String PROCESO_NAME = "CARG_MIS_V";
	private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
	private final MetadataProcedure procedure;
	
	private @Autowired
	DataSource dataSource;

	public CargaCobrosMiscelaneosMCService(
			@Qualifier("ICargaCobrosMiscelaneosMapper") ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper,
			@Qualifier("IProcesoProcedureMapper") IProcesoProcedureMapper procesoProcedureMapper) {
		this.cargaCobrosMiscMapper = (ICargaCobrosMiscelaneosMapper) cargaCobrosMiscMapper;
		this.procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME).orElseThrow(
				() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
		this.procedure.setParametrosProcedure(
				procesoProcedureMapper.getParametrosProcedure(procedure.getIdProcedure()));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cargarRegistro(Map<String, Object> registro) {
		Map<String, Object> general = new HashMap<>();
		
		// Cargando registro
		general.put("procedureName", procedure.getNombreProcedure());
		general.put("salida", "");
		general.put("params", registro);
		cargaCobrosMiscMapper.cargarRegistro(general);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ResultadoCargaFactura> cargarArchivos(List<MultipartFile> multipartfiles) {
		List<ResultadoCargaFactura> listaResultados = new ArrayList<>();
		for (MultipartFile multipartfile : multipartfiles) {
			String filename = multipartfile.getOriginalFilename();
			try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
				ResultadoCargaFactura resultadoCarga = leerExcel(filename, bis);
				listaResultados.add(resultadoCarga);
			} catch (IOException e) {
				throw new RecursoNoEncontradoException(e.getMessage());
			}
		}
		return listaResultados;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ResultadoCargaFactura leerExcel(String filename, InputStream inputStream){
		
		try (Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			rowIterator.next();
			List<FacturaMasterCard> listaFilas = new ArrayList<>();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				String 	documentType           = row.getCell( 0).getStringCellValue(); 	
				String 	invoiceNumber          = row.getCell( 1).getStringCellValue(); 	
				String 	currency               = row.getCell( 2).getStringCellValue(); 	
				Date   	billingCycleDate       = TypesUtil.getDateValue(row.getCell(3), "MM/dd/yy hh:mm:ss aa");   	 
				String 	invoiceIca             = row.getCell( 4).getStringCellValue(); 	
				String 	activiteIca            = row.getCell( 5).getStringCellValue(); 	
				String 	serviceCode            = row.getCell( 8).getStringCellValue(); 	
				String 	serviceCodeDescription = row.getCell( 9).getStringCellValue(); 	
				String 	eventId                = row.getCell(13).getStringCellValue(); 	
				String 	eventDescription       = row.getCell(14).getStringCellValue(); 	
				String 	affiliate              = row.getCell(15).getStringCellValue(); 	
				String 	uom                    = row.getCell(16).getStringCellValue(); 	
				Double 	quantityAmount         = TypesUtil.getNumericValue(row.getCell(17)).doubleValue(); 	
				Double 	rate                   = TypesUtil.getNumericValue(row.getCell(18)).doubleValue(); 	
				Double 	charge                 = TypesUtil.getNumericValue(row.getCell(19)).doubleValue(); 	
				Double taxCharge               = TypesUtil.getNumericValue(row.getCell(20)).doubleValue(); 
				Double 	totalCharge            = TypesUtil.getNumericValue(row.getCell(21)).doubleValue(); 	
				String 	sbfExplanatorytext     = row.getCell(26).getStringCellValue(); 	

				FacturaMasterCard fila = FacturaMasterCard.builder()
											.documentType          (documentType          )
											.invoiceNumber         (invoiceNumber         )
											.currency              (currency              )
											.billingCycleDate      (billingCycleDate      )
											.invoiceIca            (invoiceIca            )
											.activiteIca           (activiteIca           )
											.serviceCode           (serviceCode           )
											.serviceCodeDescription(serviceCodeDescription)
											.eventId               (eventId               )
											.eventDescription      (eventDescription      )
											.affiliate             (affiliate             )
											.uom                   (uom                   )
											.quantityAmount        (quantityAmount        )
											.rate                  (rate                  )
											.charge                (charge                )
											.taxCharge             (taxCharge             )
											.totalCharge           (totalCharge           )
											.sbfExplanatorytext    (sbfExplanatorytext    )
										.build();
				listaFilas.add(fila);
			}
			cargarExcel(listaFilas);
			ResultadoCargaFactura resultadoCarga = ResultadoCargaFactura.builder()
					.nombreArchivo(filename)
					.numeroRegistros(listaFilas.size())
					.fechaFactura(listaFilas.get(0).getBillingCycleDate())
					.exito(true)
					.build();
			return resultadoCarga;
		} catch (IOException ex) {
			throw new ReadingExcelFileException(
							"Asegúrese de que se trata de un archivo Excel. Nombre de archivo: " + filename);
		} catch (Exception ex) {
			ResultadoCargaFactura resultadoCargaFallida = ResultadoCargaFactura.builder()
					.nombreArchivo(filename)
					.numeroRegistros(0)
					.fechaFactura(null)
					.exito(false)
					.build();
			return resultadoCargaFallida;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void cargarExcel(List<FacturaMasterCard> listaFilas){
		int batchSize = 1000;
		if(listaFilas.size()<=0){
			return;
		}
		try(Connection conn = dataSource.getConnection()){
			conn.setAutoCommit(false);
			try{
				PreparedStatement stmtDelete = conn.prepareStatement("DELETE FROM MOV_FACTURACION_MC " + 
				"WHERE BILLING_CYCLE_DATE = ? " +
				"AND INVOICE_ICA = ?");
				FacturaMasterCard aux = listaFilas.get(0);
				TypesUtil.validarBDFecha(stmtDelete,  1, aux.getBillingCycleDate());
				TypesUtil.validarBDString(stmtDelete,  2, aux.getInvoiceIca());
				stmtDelete.addBatch();
				stmtDelete.executeBatch();
				conn.commit();
				try{
					PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO MOV_FACTURACION_MC("+
							"DOCUMENT_TYPE	            ," + 
							"INVOICE_NUMBER	            ," + 
							"CURRENCY	                ," + 
							"BILLING_CYCLE_DATE	        ," + 
							"INVOICE_ICA	            ," + 
							"ACTIVITE_ICA	            ," + 
							"SERVICE_CODE	            ," + 
							"SERVICE_CODE_DESCRIPTION	," + 
							"EVENT_ID	                ," + 
							"EVENT_DESCRIPTION	        ," + 
							"AFFILIATE	                ," + 
							"UOM	                    ," + 
							"QUANTITY_AMOUNT	        ," + 
							"RATE	                    ," + 
							"CHARGE	                    ," + 
							"TAX_CHARGE	                ," + 
							"TOTAL_CHARGE	            ," + 
							"SBF_EXPLANATORY_TEXT	    " +
						") VALUES ("+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?"+
						")") ;
					int[] idx = { 0 };
					Iterator<FacturaMasterCard> itFacturaMasterCard = listaFilas.iterator();
					FacturaMasterCard facturaMC;
					while(itFacturaMasterCard.hasNext()){
						facturaMC = itFacturaMasterCard.next();
						try{
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getDocumentType          ());
							TypesUtil.validarBDString (stmt,  2,  	facturaMC.getInvoiceNumber         ());
							TypesUtil.validarBDString (stmt,  3,  	facturaMC.getCurrency              ());
							TypesUtil.validarBDFecha  (stmt,  4, 	facturaMC.getBillingCycleDate      ());
							TypesUtil.validarBDString (stmt,  5,  	facturaMC.getInvoiceIca            ());
							TypesUtil.validarBDString (stmt,  6,  	facturaMC.getActiviteIca           ());
							TypesUtil.validarBDString (stmt,  7,  	facturaMC.getServiceCode           ());
							TypesUtil.validarBDString (stmt,  8,  	facturaMC.getServiceCodeDescription());
							TypesUtil.validarBDString (stmt,  9,  	facturaMC.getEventId               ());
							TypesUtil.validarBDString (stmt, 10,  	facturaMC.getEventDescription      ());
							TypesUtil.validarBDString (stmt, 11,  	facturaMC.getAffiliate             ());
							TypesUtil.validarBDString (stmt, 12,  	facturaMC.getUom                   ());
							TypesUtil.validarBDDouble (stmt, 13,  	facturaMC.getQuantityAmount        ());
							TypesUtil.validarBDDouble (stmt, 14,  	facturaMC.getRate                  ());
							TypesUtil.validarBDDouble (stmt, 15,  	facturaMC.getCharge                ());
							TypesUtil.validarBDDouble (stmt, 16,  	facturaMC.getTaxCharge             ());
							TypesUtil.validarBDDouble (stmt, 17,  	facturaMC.getTotalCharge           ());
							TypesUtil.validarBDString (stmt, 18,  	facturaMC.getSbfExplanatorytext    ());
							stmt.addBatch();
							idx[0]++;
							if (idx[0] % batchSize == 0 ) {
								stmt.executeBatch();
								conn.commit();
								stmt.clearBatch();
								stmt.clearParameters();
								idx[0] = 0;
							}
						}catch(SQLException e){
							if (conn != null) {
								try {
									conn.rollback();
								} catch (Exception ex) {
								}
							}
						}
					}

					if(idx[0]>0){
						stmt.executeBatch();
						conn.commit();
					}
					
					PreparedStatement stmtUpdate = conn.prepareStatement("{CALL PKG_CARGA.PRC_ACTUALIZAR_REGISTROS_MC (?)}");
					TypesUtil.validarBDFecha(stmtUpdate,  1, aux.getBillingCycleDate());
					stmtUpdate.addBatch();
					stmtUpdate.executeBatch();
					conn.commit();
				}catch(SQLException e){
					if (conn != null) {
						try {
							conn.rollback();
						} catch (Exception ex) {
						}
					}
					e.printStackTrace();
				}
			}catch(SQLException e) {
				if (conn != null) {
					try {
						conn.rollback();
					} catch (Exception ex) {
					}
				}
				e.printStackTrace();
			}
		}catch (SQLException e ){
			e.printStackTrace();
		}
	}
	
}