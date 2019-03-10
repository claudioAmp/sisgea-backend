package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import ob.unibanca.sicf.facturacion.mapper.ICargaCobrosMiscelaneosMapper;
import ob.unibanca.sicf.facturacion.mapper.IProcesoProcedureMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
      Map<String, Object> general = new HashMap<String, Object>();
      general.put("procedureName", procedure.getNombreProcedure());
      general.put("salida", "");
      general.put("params", registro);
      general.put("filename", filename);
      general.put("reproceso", procedure.isEsReproceso());
      cargaCobrosMiscMapper.cargarRegistro(general);
      System.out.println(general.get("salida"));
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
   public String cargarArchivos(File file) {
      filename = file.getName();
      procedure = procesoProcedureMapper.getMetadataProcedureProceso(PROCESO_NAME, filename)
            .orElseThrow(() -> new RecursoNoEncontradoException(PROCESO_NO_ENCONTRADO, PROCESO_NAME));
      try {
         CargaArchivoExcel.readExcelFile(file,
               procesoProcedureMapper.getParametrosProcedure(procedure.getIdProcedure()), this, true, 0, procedure.getPatronFechaArchivo());
      } catch (ReadingExcelFileException e) {
         throw new RecursoNoEncontradoException("ERROR: ", e.getMessage());
      }
      return "ARCHIVO CARGADO! " + procedure.isEsReproceso();
   }

}