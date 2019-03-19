package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;

public class MyBATISClienteDAO implements ClienteDAO{

	@Inject
	 private ClienteMapper clienteMapper;    
	
	@Override
	public void save(Cliente cl) throws PersistenceException{
		  try{
			 
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar el cliente "+cl.toString(),e);
		  }        

		  }
	 @Override
	 public Cliente load(long docu) throws PersistenceException {
	  try{
	      return clienteMapper.consultarCliente(docu);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el cliente "+docu,e);
	  }
	  }
	@Override
	public List<Cliente> load() throws PersistenceException {
		try{
		      return clienteMapper.consultarClientes();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar los clientes ",e);
		  }
		}
}
