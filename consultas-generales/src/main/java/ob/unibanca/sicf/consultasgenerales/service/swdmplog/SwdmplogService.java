package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import org.springframework.stereotype.Service;

import ob.unibanca.sicf.consultasgenerales.mapper.ISwdmplogMapper;

@Service
public class SwdmplogService implements ISwdmplogService {
	
	private final ISwdmplogMapper swdmplogMapper;
	
	public SwdmplogService(ISwdmplogMapper swdmplogMapper) {
		this.swdmplogMapper = swdmplogMapper;
	}
}
