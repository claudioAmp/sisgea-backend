package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Mapper
public interface ISwdmplogMapper {

	List<TxnSwdmplog> buscarPorCriterios();
}
