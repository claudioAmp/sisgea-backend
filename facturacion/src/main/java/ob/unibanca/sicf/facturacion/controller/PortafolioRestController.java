package ob.unibanca.sicf.facturacion.controller;

import ob.unibanca.sicf.facturacion.model.Portafolio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento/facturacion")
public class PortafolioRestController {

    @GetMapping("portafolios")
    public List<Portafolio> buscarTodosPortafolios() {
        return List.of(Portafolio.builder().idPortafolio("id-portafolio").descripcionPortafolio("descripcion").build());
    }
}
