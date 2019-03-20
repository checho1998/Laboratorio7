package edu.eci.cvds;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import java.util.ArrayList;

import edu.eci.cvds.samples.entities.*;


public class ClienteGenerator {

	public static Gen<Cliente> generadorClientes(){
		return generadorNombre().zip( generadorDocumento(), generadorTelefono(), generadorDireccion(), generadorEmail(),
				(nombre, documento, telefono, direccion,email)-> 
					new Cliente(nombre, documento, telefono, direccion,email));
	}
	
	public static Gen<String> generadorNombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 50);
	}
	
	public static Gen<Long> generadorDocumento(){
		return Generate.longRange(100, 50000); 
	}
	
	public static Gen<String> generadorTelefono(){
		return strings().numericBetween(10000, 100000000);
	}
	
	public static Gen<String> generadorDireccion(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 60);
	}
	
	public static Gen<String> generadorEmail(){
		return strings().basicLatinAlphabet().ofLengthBetween(5, 30).map(x ->  {return x+"@karenAna.com";});
	}
}