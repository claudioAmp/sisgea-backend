package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;
import ob.unibanca.sicf.consultasgenerales.model.facturamastercard.FacturaMasterCard;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.error.model.ErrorResponse;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;
import ob.unibanca.sicf.facturacion.model.MetadataProcedure;
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
	//private final IProcesoProcedureMapper procesoProcedureMapper;
	private final MetadataProcedure procedure;
	
	private @Autowired
	DataSource dataSource;

	public CargaCobrosMiscelaneosMCService(
			@Qualifier("ICargaCobrosMiscelaneosMapper") ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper,
			@Qualifier("IProcesoProcedureMapper") IProcesoProcedureMapper procesoProcedureMapper) {
		this.cargaCobrosMiscMapper = (ICargaCobrosMiscelaneosMapper) cargaCobrosMiscMapper;
		//this.procesoProcedureMapper = (IProcesoProcedureMapper) procesoProcedureMapper;
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
	public List<ErrorResponse> cargarArchivos(List<MultipartFile> multipartfiles) {
		List<ErrorResponse> listaExcepciones = new ArrayList<>();
		/*
		for (MultipartFile multipartfile : multipartfiles) {
			List<ErrorResponse> aux;
			String filename = multipartfile.getOriginalFilename();
			boolean esReproceso = procesoProcedureMapper.isReproceso(filename);
			HashMap<String, Object> parametrosAdicionales = new HashMap<>();
			parametrosAdicionales.put("filename", filename);
			parametrosAdicionales.put("reproceso", esReproceso);
			
			try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
				aux = CargaArchivoExcel.readExcelFile(filename, bis, this.procedure.getParametrosProcedure(), this,
				                                      true, 0, this.procedure.getPatronFechaArchivo(), false,
				                                      parametrosAdicionales);
				
				if (aux != null) {
					aux.stream().filter(Objects::nonNull).forEachOrdered(listaExcepciones::add);
				}
			} catch (IOException e) {
				throw new RecursoNoEncontradoException(e.getMessage());
			}
		}*/
		
		for (MultipartFile multipartfile : multipartfiles) {
			String filename = multipartfile.getOriginalFilename();
			
			try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
				leerExcel(filename, bis);
			} catch (IOException e) {
				throw new RecursoNoEncontradoException(e.getMessage());
			}
		}
		return listaExcepciones;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void leerExcel(String filename, InputStream inputStream){
		
		try (Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			rowIterator.next();
			List<FacturaMasterCard> listaFilas = new ArrayList<>();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// row.getCell(columnAux)
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
				Double 	quantityAmount         = (Double) TypesUtil.getNumericValue(row.getCell(17)); 	
				Double 	rate                   = (Double) TypesUtil.getNumericValue(row.getCell(18)); 	
				Double 	charge                 = (Double) TypesUtil.getNumericValue(row.getCell(19)); 	
				Integer taxCharge              = TypesUtil.getNumericValue(row.getCell(20)).intValue(); 
				Double 	totalCharge            = (Double) TypesUtil.getNumericValue(row.getCell(21)); 	
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
		} catch (IOException ex) {
			throw new ReadingExcelFileException(
							"Asegúrese de que se trata de un archivo Excel. Nombre de archivo: " + filename);
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
				PreparedStatement stmtDelete = conn.prepareStatement("DELETE FROM MOV_FACTURACION_MASTERCARD WHERE billing_Cycle_Date = ? ");
				FacturaMasterCard aux = listaFilas.get(0);
				TypesUtil.validarBDFecha(stmtDelete,  1, aux.getBillingCycleDate());
				stmtDelete.addBatch();
				stmtDelete.executeBatch();
				conn.commit();
				try{
					PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO MOV_FACTURACION_MASTERCARD("+
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
							"SBF_EXPLANATORY_TEXT	    ," +
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
							"?,"+
						")") ;
					int[] idx = { 0 };
					Iterator<FacturaMasterCard> itFacturaMasterCard = listaFilas.iterator();
					FacturaMasterCard facturaMC;
					while(itFacturaMasterCard.hasNext()){
						facturaMC = itFacturaMasterCard.next();
						try{
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getDocumentType          ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getInvoiceNumber         ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getCurrency              ());
							TypesUtil.validarBDFecha  (stmt,  2, 	facturaMC.getBillingCycleDate      ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getInvoiceIca            ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getActiviteIca           ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getServiceCode           ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getServiceCodeDescription());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getEventId               ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getEventDescription      ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getAffiliate             ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getUom                   ());
							TypesUtil.validarBDDouble (stmt, 18,  	facturaMC.getQuantityAmount        ());
							TypesUtil.validarBDDouble (stmt, 18,  	facturaMC.getRate                  ());
							TypesUtil.validarBDDouble (stmt, 18,  	facturaMC.getCharge                ());
							TypesUtil.validarBDInteger(stmt, 15,  	facturaMC.getTaxCharge             ());
							TypesUtil.validarBDDouble (stmt, 18,  	facturaMC.getTotalCharge           ());
							TypesUtil.validarBDString (stmt,  1,  	facturaMC.getSbfExplanatorytext    ());
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
					
					PreparedStatement stmtUpdate = conn.prepareStatement(
						"UPDATE MOV_FACTURACION_MASTERCARD"+
						"SET ID_REGISTRO_MC = TO_DATE('YYYYMMDD', BILLING_CYCLE_DATE) || LPAD(ROW_NUMBER(), 18, '0')"+
						"WHERE BILLING_CYCLE_DATE = ? "
					);
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