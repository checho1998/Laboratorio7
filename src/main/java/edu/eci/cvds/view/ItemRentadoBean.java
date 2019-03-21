package edu.eci.cvds.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import org.primefaces.context.RequestContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;


/**
 *
 * @author salzate
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "itemRentado")
@RequestScoped
public class ItemRentadoBean extends BasePageBean {
	
	
	@ManagedProperty(value = "#{param.documento}")
	private long documento;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
   
    public List<ItemRentado> getItems()throws Exception{
        try {
            return serviciosAlquiler.consultarItemsCliente(documento);
        } catch (ExcepcionServiciosAlquiler ex) {
            throw ex;
        }
    }
   
    public long consultarMulta(int idItem) throws ExcepcionServiciosAlquiler{
    	try{
    		java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    		return serviciosAlquiler.consultarMultaAlquiler(idItem, sqlDate);
    	}catch (ExcepcionServiciosAlquiler ex) {
            throw ex;
        }
    }
    
    public void consultarCosto(int iditem, int numdias) throws ExcepcionServiciosAlquiler{
    	try {
    		
    		long precio= serviciosAlquiler.consultarCostoAlquiler(iditem, numdias);
    		RequestContext reqCtx = RequestContext.getCurrentInstance();        
			reqCtx.addCallbackParam("returnedValue", precio);
    	}catch(ExcepcionServiciosAlquiler ex) {
    		throw ex;
    	}
    }
    
   
    public void registrarItem(int id ,int numdias) throws Exception{
    	
    	
    	try {
    		Item item=serviciosAlquiler.consultarItem(id);
        	java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    		serviciosAlquiler.registrarAlquilerCliente(date, documento, item, numdias);
		 }catch (ExcepcionServiciosAlquiler e) {
			 e.getStackTrace();
		 }
    	
    }
    
   
    /**
	 * @return the documento
	 */
	
    public long getDocumento() {
		return documento;
	}

	/**
	 * @param user the documento to set
	 */
	public void setDocumento(long documento) {
		this.documento = documento;
	}

    
}