package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;
import java.util.List;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
	public long consultarDiasRetraso(@Param("id")int iditem, @Param("fecha")java.sql.Date fechaDevolucion);
	public List<ItemRentado> consultarItemsRentados(@Param("documento")long documento);

}
