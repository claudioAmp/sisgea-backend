package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.error.model.ErrorResponse;
import ob.commons.excel.CargaArchivoExcel;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;
import ob.unibanca.sicf.facturacion.model.FacturacionVisa;
import ob.unibanca.sicf.facturacion.model.MetadataProcedure;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CargaCobrosMiscelaneosVisaService implements ICargaCobrosMiscelaneosVisaService {
	
	private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
	private static final String PROCESO_NAME = "CARG_MIS_V";
	private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
	private final IProcesoProcedureMapper procesoProcedureMapper;
	private final MetadataProcedure procedure;
	
	public CargaCobrosMiscelaneosVisaService(
			@Qualifier("ICargaCobrosMiscelaneosMapper") ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper,
			@Qualifier("IProcesoProcedureMapper") IProcesoProcedureMapper procesoProcedureMapper) {
		this.cargaCobrosMiscMapper = (ICargaCobrosMiscelaneosMapper) cargaCobrosMiscMapper;
		this.procesoProcedureMapper = (IProcesoProcedureMapper) procesoProcedureMapper;
		this.procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME).orElseThrow(
				() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
		this.procedure.setParametrosProcedure(
				procesoProcedureMapper.getParametrosProcedure(procedure.getIdProcedure()));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cargarRegistro(Map<String, Object> registro) {
		Map<String, Object> general = new HashMap<>();
		System.out.println(procedure);
		System.out.println(registro);
		System.out.println(general);
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
		for (MultipartFile multipartfile : multipartfiles) {
			List<ErrorResponse> aux;
			String filename = multipartfile.getOriginalFilename();
			String extension = filename.substring(filename.lastIndexOf(".") + 1);
			boolean esReproceso = procesoProcedureMapper.isReproceso(filename);
			HashMap<String, Object> parametrosAdicionales = new HashMap<>();
			parametrosAdicionales.put("filename", filename);
			parametrosAdicionales.put("reproceso", esReproceso);
			
			
			try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
				List<Map<String, Object>> listaCargada = CargaArchivoExcel.readExcelFile(filename, 
													  bis, 
													  this.procedure.getParametrosProcedure(), 
													  this,
				                                      true, 
				                                      0, 
				                                      this.procedure.getPatronFechaArchivo(), 
				                                      esReproceso,
				                                      parametrosAdicionales,
				                                      //Nuevo
				                                      extension);
				System.out.println(listaCargada);
				listaCargada.forEach(registroCargado ->{
					@SuppressWarnings("unchecked")
					Map<String, Object> params = (Map<String, Object>) registroCargado;
					FacturacionVisa facturacionVisa = FacturacionVisa.builder()
							.billingPeriod(params.get("BILLING_PERIOD").toString())
							//.invoiceDate(new Date(params.get("INVOICE_DATE").toString()))
							.name(params.get("NAME").toString())
							.invoiceId(params.get("INVOICE_ID").toString())
							.subInvoice(params.get("SUB_INVOICE").toString())
							.entityType(params.get("ENTITY_TYPE").toString())
							.entityId(params.get("ENTITY_ID").toString())
							.binMap(params.get("BIN_MAP").toString())
							.settlementId(params.get("SETTLEMENT_ID").toString())
							.description(params.get("DESCRIPTION").toString())
							.billingLine(params.get("BILLING_LINE").toString())
							.type(params.get("TYPE").toString())
							.rateType(params.get("RATE_TYPE").toString())
							.units(Integer.parseInt(params.get("UNITS").toString()))
							.rateCur(params.get("RATE").toString())
							.rate(Double.parseDouble(params.get("RATE").toString()))
							.foreingExchangeRate(Integer.parseInt(params.get("FOREIGN_EXCHANGE_RATE").toString()))
							.billingCurrency(params.get("BILLING_CURRENCY").toString())
							.total(Double.parseDouble(params.get("TOTAL").toString()))
							.build();
					System.out.println(facturacionVisa);
				});
				
			
			} catch (IOException e) {
				throw new RecursoNoEncontradoException(e.getMessage());
			}
		}
		return listaExcepciones;
	}
	
}