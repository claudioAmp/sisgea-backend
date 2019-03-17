package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
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

import ob.commons.validation.model.ErrorResponse;

@Service
public class CargaCobrosMiscelaneosMCService implements ICargaCobrosMiscelaneosMCService {

   private static final String PROCESO_NO_ENCONTRADO = "El proceso de carga %s no fue encontrado";
   private static final String PROCESO_NAME = "CARG_MIS_MC";
   private final ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper;
   private final IProcesoProcedureMapper procesoProcedureMapper;
   private final MetadataProcedure procedure;

   public CargaCobrosMiscelaneosMCService(
         @Qualifier("ICargaCobrosMiscelaneosMapper") ICargaCobrosMiscelaneosMapper cargaCobrosMiscMapper,
         @Qualifier("IProcesoProcedureMapper") IProcesoProcedureMapper procesoProcedureMapper) {
      this.cargaCobrosMiscMapper = (ICargaCobrosMiscelaneosMapper) cargaCobrosMiscMapper;
      this.procesoProcedureMapper = (IProcesoProcedureMapper) procesoProcedureMapper;
      this.procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME)
            .orElseThrow(() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
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
      for (MultipartFile multipartfile : multipartfiles) {
         List<ErrorResponse> aux;
         String filename = multipartfile.getOriginalFilename();
         boolean esReproceso = procesoProcedureMapper.isReproceso(filename);
         HashMap<String, Object> parametrosAdicionales = new HashMap<>();
         parametrosAdicionales.put("filename", filename);
         parametrosAdicionales.put("reproceso", esReproceso);
      
         try (BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream())) {
            aux = CargaArchivoExcel.readExcelFile(filename, bis,
                  this.procedure.getParametrosProcedure(), this, true, 0,
                  this.procedure.getPatronFechaArchivo(), esReproceso, parametrosAdicionales);
            if(aux!=null){
               aux.stream()
                  .filter(Objects::nonNull)
                  .forEachOrdered(listaExcepciones::add);
            }
         } catch (IOException e) {
            throw new RecursoNoEncontradoException(e.getMessage());
         }
      }
      return listaExcepciones;
   }

}