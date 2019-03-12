package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ob.commons.excel.CargaArchivoExcel;
import ob.commons.excel.exception.ReadingExcelFileException;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.facturacion.model.MetadataProcedure;

@Service
public class CargaCobrosMiscelaneosVisaService implements ICargaCobrosMiscelaneosVisaService {

   private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
   private static final String PROCESO_NAME = "CARG_MIS_V";
   private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
   private final IProcesoProcedureMapper procesoProcedureMapper;
   private MetadataProcedure procedure;
   private String filename;

   public CargaCobrosMiscelaneosVisaService(
         @Qualifier("ICargaCobrosMiscelaneosMapper") ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper,
         @Qualifier("IProcesoProcedureMapper") IProcesoProcedureMapper procesoProcedureMapper) {
      this.cargaCobrosMiscMapper = (ICargaCobrosMiscelaneosMapper) cargaCobrosMiscMapper;
      this.procesoProcedureMapper = (IProcesoProcedureMapper) procesoProcedureMapper;
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void cargarRegistro(Map<String, Object> registro) {
      Map<String, Object> general = new HashMap<>();
      // Añadiendo parametros
      registro.put("filename", filename);
      registro.put("reproceso", procedure.isEsReproceso());

      // Cargando registro
      general.put("procedureName", procedure.getNombreProcedure());
      general.put("salida", "");
      general.put("params", registro);
      cargaCobrosMiscMapper.cargarRegistro(general);
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void reportarErrorEnFila(int fila, Exception e) {
      // Por implementar
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void reportarErrorEnCelda(int fila, int columna, Exception e) {
      // Por implementar
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public String cargarArchivos(MultipartFile multipartfile) {
      filename = multipartfile.getOriginalFilename();
      procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME, filename)
            .orElseThrow(() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
      
      try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())){
         CargaArchivoExcel.readExcelFile(filename, bis,
               procesoProcedureMapper.getParametrosProcedure(procedure.getIdProcedure()), this, true, 0, procedure.getPatronFechaArchivo());
      
      } catch (ReadingExcelFileException | IOException e) {
         throw new RecursoNoEncontradoException("ERROR: ", e.getMessage());
      }
      return "ARCHIVO CARGADO. " + (procedure.isEsReproceso()?"Hubo reproceso":"No hubo reproceso");
   }

}