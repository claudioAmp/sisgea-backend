package ob.unibanca.sicf.mantenimientosgenerales.controller.restcontroller;

import ob.unibanca.sicf.mantenimientosgenerales.model.Membresia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento/general/")
public class MembresiaRestController {

    @GetMapping("membresias")
    public List<Membresia> buscarTodosMembresias() {
        return List.of(Membresia.builder().idMembresia("V").descripcionMembresia("VISA").build());
    }
}
