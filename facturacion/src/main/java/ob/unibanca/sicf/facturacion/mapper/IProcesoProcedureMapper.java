package ob.unibanca.sicf.facturacion.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.unibanca.sicf.facturacion.model.MetadataProcedure;

import ob.commons.excel.usermodel.Campo;

import java.util.List;

import java.util.Optional;

@Mapper
public interface IProcesoProcedureMapper {

	public Optional<MetadataProcedure> getMetadataProcedureProceso(String idProceso, String filename);
	
	public List<Campo> getParametrosProcedure(String idProcedure);

}
