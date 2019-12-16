package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;
import ob.unibanca.sicf.consultasgenerales.model.facturavisa.FacturaVisa;
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
public class CargaCobrosMiscelaneosVisaService implements ICargaCobrosMiscelaneosVisaService {
	
	private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
	private static final String PROCESO_NAME = "CARG_MIS_V";
	private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
	//private final IProcesoProcedureMapper procesoProcedureMapper;
	private final MetadataProcedure procedure;
	
	private @Autowired
	DataSource dataSource;

	public CargaCobrosMiscelaneosVisaService(
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
			List<FacturaVisa> listaFilas = new ArrayList<>();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// row.getCell(columnAux)
				String billingPeriod 	= row.getCell(0).getStringCellValue(); 	
				Date invoiceDate 		= TypesUtil.getDateValue(row.getCell(1), "dd-MMM-yyyy");       
				String invoiceAccount 	= row.getCell(2).getStringCellValue();  
				String name 			= row.getCell(3).getStringCellValue();        	
				String invoiceId 		= row.getCell(4).getStringCellValue();       
				String subInvoice 		= row.getCell(5).getStringCellValue();      
				String entityType		= row.getCell(7).getStringCellValue();      
				String entityId			= row.getCell(8).getStringCellValue();        
				String binMap			= row.getCell(9).getStringCellValue();        	
				String settlementId		= row.getCell(11).getStringCellValue();    
				String description		= row.getCell(12).getStringCellValue();     
				String billingLine		= row.getCell(15).getStringCellValue();     
				String type				= row.getCell(16).getStringCellValue();        	
				String rateType			= row.getCell(17).getStringCellValue();        
				int units				= TypesUtil.getNumericValue(row.getCell(18)).intValue();        		
				String rateCur			= row.getCell(19).getStringCellValue();        	
				double rate				= (double) TypesUtil.getNumericValue(row.getCell(20));        	
				double foreignExchange	= (double) TypesUtil.getNumericValue(row.getCell(21));
				String billingCurrency	= row.getCell(22).getStringCellValue();
				double total			= (double) TypesUtil.getNumericValue(row.getCell(23));      	
				FacturaVisa fila = FacturaVisa.builder()
									.billingPeriod 	(billingPeriod 	)
									.invoiceDate    (invoiceDate    ) 
									.invoiceAccount (invoiceAccount ) 
									.name        	(name        	)
									.invoiceId      (invoiceId      ) 
									.subInvoice     (subInvoice     ) 
									.entityType     (entityType     ) 
									.entityId       (entityId       ) 
									.binMap        	(binMap        	)
									.settlementId   (settlementId   ) 
									.description    (description    ) 
									.billingLine    (billingLine    ) 
									.type        	(type        	)
									.rateType       (rateType       ) 
									.units        	(units        	)
									.rateCur        (rateCur        )	
									.rate        	(rate        	)
									.foreignExchange(foreignExchange) 
									.billingCurrency(billingCurrency) 
									.total        	(total        	)
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
	public void cargarExcel(List<FacturaVisa> listaFilas){
		int batchSize = 1000;
		if(listaFilas.size()<=0){
			return;
		}
		try(Connection conn = dataSource.getConnection()){
			conn.setAutoCommit(false);
			try{
				PreparedStatement stmtDelete = conn.prepareStatement("DELETE FROM MOV_FACTURACION_VISA WHERE INVOICE_DATE = ? ");
				FacturaVisa aux = listaFilas.get(0);
				TypesUtil.validarBDFecha(stmtDelete,  1, aux.getInvoiceDate());
				stmtDelete.addBatch();
				stmtDelete.executeBatch();
				conn.commit();
				try{
					PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO MOV_FACTURACION_VISA("+
							"BILLING_PERIOD	      ," +
							"INVOICE_DATE	      ," +
							"INVOICE_ACCOUNT	  ," +   
							"NAME	              ," +
							"INVOICE_ID	          ," +
							"SUB_INVOICE	      ," +   
							"ENTITY_TYPE	      ," +   
							"ENTITY_ID	          ," +
							"BIN_MAP	          ," +   
							"SETTLEMENT_ID	      ," +
							"DESCRIPTION	      ," +   
							"BILLING_LINE	      ," +
							"TYPE	              ," +
							"RATE_TYPE	          ," +
							"UNITS	              ," +
							"RATE_CUR	          ," +
							"RATE	              ," +
							"FOREIGN_EXCHANGE_RATE," +
							"BILLING_CURRENCY	  ," +
							"TOTAL	              " +
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
							"?,"+
							"? "+
						")") ;
					int[] idx = { 0 };
					Iterator<FacturaVisa> itFacturaVisa = listaFilas.iterator();
					FacturaVisa facturaVisa;
					while(itFacturaVisa.hasNext()){
						facturaVisa = itFacturaVisa.next();
						try{
							TypesUtil.validarBDString(stmt,  1, facturaVisa.getBillingPeriod 	())    ;
							TypesUtil.validarBDFecha (stmt,  2, facturaVisa.getInvoiceDate     () )  ;
							TypesUtil.validarBDString(stmt,  3, facturaVisa.getInvoiceAccount  () )  ;
							TypesUtil.validarBDString(stmt,  4, facturaVisa.getName        	()    );
							TypesUtil.validarBDString(stmt,  5, facturaVisa.getInvoiceId       () )  ;
							TypesUtil.validarBDString(stmt,  6, facturaVisa.getSubInvoice      () )  ;
							TypesUtil.validarBDString(stmt,  7, facturaVisa.getEntityType      () )  ;
							TypesUtil.validarBDString(stmt,  8, facturaVisa.getEntityId        () )  ;
							TypesUtil.validarBDString(stmt,  9, facturaVisa.getBinMap        	())    ;
							TypesUtil.validarBDString(stmt, 10, facturaVisa.getSettlementId    () )  ;
							TypesUtil.validarBDString(stmt, 11, facturaVisa.getDescription     () )  ;
							TypesUtil.validarBDString(stmt, 12, facturaVisa.getBillingLine     () )  ;
							TypesUtil.validarBDString(stmt, 13, facturaVisa.getType        	()    );
							TypesUtil.validarBDString(stmt, 14, facturaVisa.getRateType        () )  ;
							TypesUtil.validarBDInteger(stmt, 15, facturaVisa.getUnits        	())    ;
							TypesUtil.validarBDString(stmt, 16, facturaVisa.getRateCur         () )  ;
							TypesUtil.validarBDDouble(stmt, 17, facturaVisa.getRate        	()    );
							TypesUtil.validarBDDouble(stmt, 18, facturaVisa.getForeignExchange () )  ;
							TypesUtil.validarBDString(stmt, 19, facturaVisa.getBillingCurrency () )  ;
							TypesUtil.validarBDDouble(stmt, 20, facturaVisa.getTotal        	())    ;
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
					
					PreparedStatement stmtUpdate = conn.prepareStatement("{CALL PKG_CARGA.PRC_ACTUALIZAR_REGISTROS_VISA (?)}");
					TypesUtil.validarBDFecha(stmtUpdate,  1, aux.getInvoiceDate());
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