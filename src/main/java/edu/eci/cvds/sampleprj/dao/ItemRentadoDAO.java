package edu.eci.cvds.sampleprj.dao;
import java.sql.Date;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	
	public long MultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException;
	public List<ItemRentado> consultarItemsRentados(long documento) throws PersistenceException;
	
}
