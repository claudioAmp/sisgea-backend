package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import edu.taller.sisgea.mantenimientosgenerales.model.Producto;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.service.producto.IProductoService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.HashMap;

import java.util.List;

@Validated
@Controller
public class ProductoExportacionController {

    private final IProductoService productoService;

    public ProductoExportacionController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PreAuthorize("hasPermission('MANT_PRODUCTO', '5')")
    @GetMapping(value = "/productos.xlsx")
    public ModelAndView exportarProducto(ModelMap model) {
        Map<String, Object> params = new HashMap<>();
        List<Producto> lista = productoService.buscarTodosProductos();
        params.put("mantenimiento", lista);
        params.put("username", UsuarioUtil.obtenerUsername());
        params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
        model.addAttribute("template", "mantenimientosgenerales/producto");
        model.addAttribute("name", "Reporte Producto");
        model.addAttribute("params", params);
        return new ModelAndView("jxlsView", model);
    }
}
