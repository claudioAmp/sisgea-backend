package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;
import ob.unibanca.sicf.facturacion.model.MetadataProcedure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ob.commons.excel.CargaArchivoExcel;
import ob.commons.validation.exception.RecursoNoEncontradoException;

@Service
public class CargaCobrosMiscelaneosVisaService implements ICargaCobrosMiscelaneosVisaService {

   private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
   private static final String PROCESO_NAME = "CARG_MIS_V";
   private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
   private final IProcesoProcedureMapper procesoProcedureMapper;
   private MetadataProcedure procedure;

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

      // Cargando registro
      general.put("procedureName", procedure.getNombreProcedure());
      general.put("salida", "");
      general.put("params", registro);
      cargaCobrosMiscMapper.cargarRegistro(general);
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void reportarErrorEnFila(int fila, Exception e) {
      System.out.println("ERROOOOOOOOOOOOOOOR: fila: "+fila);
      // Por implementar
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void reportarErrorEnCelda(int fila, int columna, Exception e) {
      System.out.println("ERROOOOOOOOOOOOOOOR: fila: "+fila+" columna: "+columna);
      // Por implementar
   }

   @Override
   @Transactional(propagation = Propagation.REQUIRED)
   public void cargarArchivos(List<MultipartFile> multipartfiles) {
      for (MultipartFile multipartfile : multipartfiles) {
         String filename = multipartfile.getOriginalFilename();
         procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME, filename)
               .orElseThrow(() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
         HashMap<String, Object> parametrosAdicionales = new HashMap<>();
   
         parametrosAdicionales.put("filename", filename);
         parametrosAdicionales.put("reproceso", procedure.isEsReproceso());
      
         try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
            CargaArchivoExcel.readExcelFile(filename, bis,
                  procesoProcedureMapper.getParametrosProcedure(procedure.getIdProcedure()), this, true, 0,
                  procedure.getPatronFechaArchivo(), parametrosAdicionales);

         } catch (IOException e) {
            throw new RecursoNoEncontradoException("ERROR: ", e.getMessage());
         }
      }
   }

}