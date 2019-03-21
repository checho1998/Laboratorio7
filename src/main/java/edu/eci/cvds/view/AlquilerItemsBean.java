package edu.eci.cvds.view;

import java.util.List;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;


@SuppressWarnings("deprecation")
@ManagedBean(name = "itembean")
@SessionScoped
public class AlquilerItemsBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServiciosAlquiler serviciosAlquiler;

    public List<Cliente> getClientes() throws Exception{
        try {
        	
            return serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler ex) {
            throw ex;
        }
    }
    
    
    public void registrarCliente(String nombre, long documento, String telefono, String direccion, String email) throws Exception{
    	FacesContext context = FacesContext.getCurrentInstance(); 
    	Cliente c = new Cliente(nombre, documento, telefono, direccion, email);
    	
    	try {
    		serviciosAlquiler.registrarCliente(c);
			context.addMessage(null, new FacesMessage("Successful",  "Ha sido registrado exitosamente"));
		 }catch (ExcepcionServiciosAlquiler e) {
			 e.getStackTrace();
			 context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fatal","No se pudo registrar"));
		 }
    	
    }
    
    

    
}