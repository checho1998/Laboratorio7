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

import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.*;



public class TipoItemGenerator {

	public static Gen<TipoItem> generadorTipoItem(){
		return generadorId().zip(generadorDescripcion(), 
				(id,descripcion)-> 
					new TipoItem(id, descripcion));
	}
	
	public static Gen<Integer> generadorId(){
		return Generate.range(0, Integer.MAX_VALUE);
	}

	public static Gen<String> generadorDescripcion(){
		return strings().basicLatinAlphabet().ofLengthBetween(20, 60);
	}

}