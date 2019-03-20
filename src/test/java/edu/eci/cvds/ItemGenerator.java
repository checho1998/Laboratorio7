package edu.eci.cvds;


import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import org.quicktheories.generators.LocalDatesDSL;

import static org.quicktheories.generators.SourceDSL.*;
import static org.quicktheories.generators.LocalDatesDSL.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.*;

public class ItemGenerator {

	public static Gen<Item> generadorItem(){
		return generadorId().zip(generadorNombre(), generadorTarifaxDia(), generadorGenero(), TipoItemGenerator.generadorTipoItem(), 
				(id, nombre, tarifa, genero, tipo)-> 
					new Item(tipo,id,nombre,"La Elite",new Date(2019,02,05), tarifa,"luka", genero));
	}
	public static Gen<Item> generadorItem(TipoItem tipoItem){
		return generadorId().zip(generadorNombre(), generadorTarifaxDia(), generadorGenero(), 
				(id, nombre, tarifa, genero)-> 
					new Item(tipoItem,id,nombre,"La Elite",new Date(2019,02,05), tarifa,"luka", genero));
	}
	
	public static Gen<Integer> generadorId(){
		return Generate.range(0, Integer.MAX_VALUE);
	}
	
	public static Gen<Long> generadorTarifaxDia(){
		return Generate.longRange(100, 50000); 
	}
	
	public static Gen<String> generadorNombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 50);
	}
	
	public static Gen<String> generadorGenero(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}
	
}