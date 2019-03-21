package edu.eci.cvds.samples.services.client;

import java.sql.SQLException;

import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;


public class Main {
	 public static void main(String args[]) throws ExcepcionServiciosAlquiler{
	        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(123456));
	        System.exit(0);
	 }        
}