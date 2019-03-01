package ob.unibanca.sicf.mantenimientosgenerales.service.bin;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IBINMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BINService extends MantenibleService<BIN> implements IBINService {
	
	private final IBINMapper binMapper;
	
	public BINService(@Qualifier("IBINMapper") IMantenibleMapper<BIN> mantenibleMapper) {
		super(mantenibleMapper);
		this.binMapper = (IBINMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BIN registrarBIN(BIN bin) {
		this.registrar(bin);
		return this.buscarBIN(bin.getIdBIN());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BIN actualizarBIN(String idBIN, BIN bin) {
		bin.setIdBIN(idBIN);
		this.actualizar(bin);
		return this.buscarBIN(bin.getIdBIN());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarBIN(String idBIN) {
		BIN bin = BIN.builder().idBIN(idBIN).build();
		this.eliminar(bin);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<BIN> buscarTodosBINs() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public BIN buscarBIN(String idBIN) {
		return this.binMapper.buscarUno(idBIN).orElseThrow();
	}
}
