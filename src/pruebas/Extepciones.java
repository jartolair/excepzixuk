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
	@Test
	public void testCalcularValor() {
		try{
		Pelicula p=new Pelicula();
			  p.setValoracion(5.0);
			  String[] razones =null;
			  p.setRazonesDeQueSeaBueno(razones);
			  
		    Double resultadoReal=p.calcularValor();
		    Double resultadoEsperado = 4.0;
		    assertEquals(resultadoEsperado, resultadoReal, 0.01);
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Ha salido por el error Calcular Valor");
		}
		}

}
