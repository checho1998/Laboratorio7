package edu.eci.cvds.sampleprj.dao.mybatis;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.*;
import java.util.*;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{
	@Inject
	private ItemRentadoMapper itemRentadoMapper;
	
	@Override
	public long MultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException {
		try{
			  long resul= itemRentadoMapper.consultarDiasRetraso(iditem,fechaDevolucion);
			  if (resul <= 0) {
				  return 0;
			  }
		      return resul;
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el item "+iditem,e);
		  }
	}
	
	@Override
	public List<ItemRentado> consultarItemsRentados(long documento) throws PersistenceException {
		try{
			return itemRentadoMapper.consultarItemsRentados(documento);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar item del cliente "+documento,e);
		  }
	}
}
