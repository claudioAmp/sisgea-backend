package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Operador;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOperadorMapper extends IMantenibleMapper<Operador> {
	List<Operador> buscarOperadorPorTipoDato(String tipoDato);
}

