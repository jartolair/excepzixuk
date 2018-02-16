package pruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import peliculas.Pelicula;

public class Extepciones {

	@Test(expected=FileNotFoundException.class)
	public void testCrearLectorF() throws FileNotFoundException {
	  Pelicula p =new Pelicula();
	  
	  p.setNombreFichero("NoExiste.txt");
	  Scanner lector=p.crearLectorF();
	  
	}
	
	@Test
	public void testMostrarActores() {
	  try {
		  Pelicula p=new Pelicula();
		  p.mostrarActores();
		  
	    fail("Se esperaba excepcion NullPointerException");
	  } catch(NullPointerException e) {
		  System.out.println("Ha salido por el error en Mostrar Actores");
	  }
	}
	

}
