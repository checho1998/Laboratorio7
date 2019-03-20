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

import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.*;


public class ItemRentadoGenerator {

	public static Gen<ItemRentado> generadorItemRentado(){
		ItemGenerator i = new ItemGenerator();
		return generadorId().zip(generadorDate(), generadorDate(), i.generadorItem(), 
				(id,inicio, fin, item)-> 
					new ItemRentado(id, item, (java.sql.Date) inicio, (java.sql.Date) fin));
	}
	
	public static Gen<Integer> generadorId(){
		return Generate.range(0, Integer.MAX_VALUE);
	}

	public static Gen<Date> generadorDate(){
		return dates().withMilliseconds(213987831);
	}

}