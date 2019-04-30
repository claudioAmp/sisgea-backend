/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob.unibanca.sicf.mantenimientosgenerales.mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;



 @Mapper
public interface IMetodoIdThbMapper extends IMantenibleMapper<MetodoIdThb> {
    Optional<MetodoIdThb> buscarMetodoIdThb(String idMembresia, String idMetodoIdThb);

    List<MetodoIdThb> buscarMetodoIdThbPorMembresia(String idMembresia);
}
