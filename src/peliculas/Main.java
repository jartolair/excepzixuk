package peliculas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args){
		
		final int MOSTRAR=1;
		final int MOSTRAR_POR_TITULO=2;
		final int MOSTRAR_POR_DURACION=3;
		final int INSERTAR=4;
		final int BORRAR=5;
		final int EDITAR=6;
		final int MOSTRAR_MAS_LARGA=7;
		final int SALIR=0;
		
		
		Pelicula peliF=new Pelicula();
		try {
			Scanner f=peliF.crearLectorF();
		

			ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
			if(f.hasNextLine()){
				
				while(f.hasNextLine()){
					String[] linea=f.nextLine().split(":");
					Pelicula p=new Pelicula();
					
					p.setTitulo(linea[0]);
					p.setDuracion(Double.parseDouble(linea[1]));
					String[] director=linea[2].split(" ");
					p.setDirector(new Persona(director[0],director[1]));
					String[] actores2=linea[3].split(",");
					p.anadirActores(actores2);
					
					p.setValoracion(Double.parseDouble(linea[4]));
					p.setFecha_estreno(formatter.parse(linea[5]));
					
					peliculas.add(p);
				}
			}
			
			int opcion;
			Scanner lector=new Scanner(System.in);
			do{
				System.out.println("------- Menu -------");
				System.out.println(MOSTRAR+" - Mostrar peliculas");
				System.out.println(MOSTRAR_POR_TITULO+" - Mostrar ordenados por titulo");
				System.out.println(MOSTRAR_POR_DURACION+" - Mostrar ordenados por la duracion");
				System.out.println(INSERTAR+" - Insertar Pelicula");
				System.out.println(BORRAR+" - Borrar pelicula");
				System.out.println(EDITAR+" - Editar pelicula");
				System.out.println(MOSTRAR_MAS_LARGA+" - Mostrar la pelicula que mas dura");
				System.out.println(SALIR+" - Salir");
				
				opcion=Integer.parseInt(lector.nextLine());
				switch(opcion){
				case MOSTRAR:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						mostrarPeliculas(peliculas);
					}
					break;
				case MOSTRAR_POR_TITULO:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						TituloComparator tc=new TituloComparator();
						peliculas.sort(tc);
						mostrarPeliculas(peliculas);
					}
					break;
				case MOSTRAR_POR_DURACION:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						DuracionComparator dc=new DuracionComparator();
						peliculas.sort(dc);
						mostrarPeliculas(peliculas);
					}
					break;
				case INSERTAR:
					System.out.println("Titulo de la pelicula:");
					String titulo=lector.nextLine();
					System.out.println("Duracion de la pelicula:");
					double duracion=Double.parseDouble(lector.nextLine());
					System.out.println("Director de la pelicula: [Nombre Apellido]");
					String[] director=lector.nextLine().split(" ");
					System.out.println("Actores de la pelicula: [Nombre Apellido],[Nombre Apellido]");
					String actores=lector.nextLine();
					System.out.println("Valoracion de la pelicula:");
					double valoracion=Double.parseDouble(lector.nextLine());
					System.out.println("Fecha de estreno: [DD/MM/YYYY]");
					String fecha=lector.nextLine();
					
					Pelicula p=new Pelicula();
					p.setTitulo(titulo);
					p.setDuracion(duracion);
					p.setDirector(new Persona(director[0],director[1]));
					String[] actores2=actores.split(",");
					p.anadirActores(actores2);
					p.setValoracion(valoracion);
					p.setFecha_estreno(formatter.parse(fecha));
					peliculas.add(p);
					break;
					
					
				case BORRAR:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						System.out.println("Titulo de pelicula");
						String borrar=lector.nextLine();
						Iterator<Pelicula> i=peliculas.iterator();
						while(i.hasNext()){
							if (i.next().getTitulo().equals(borrar)){
								i.remove();
							}
						}
					}
					break;
					
				case EDITAR:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						System.out.println("Titulo de pelicula");
						String editar=lector.nextLine();
						Iterator<Pelicula> i=peliculas.iterator();
						while(i.hasNext()){
							Pelicula peli=i.next();
							if (peli.getTitulo().equals(editar)){
								peli.editarPelicula();
							}
						}
					}
					
					break;
					
				case MOSTRAR_MAS_LARGA:
					if(peliculas.isEmpty()){
						System.out.println("La lista esta vacia");
					}else{
						Pelicula peli=peliculaMasLarga(peliculas);
						peli.mostrarInfo();
					}
					break;
					
				case SALIR:
					System.out.println("Programa terminado");
					break;
				default:
					System.out.println("Esa opcion no existe");
					break;
				}
				
			}while(opcion!=SALIR);
			
			guardarLista(peliculas);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: No se ha encontrado el fichero al leer");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: formato de fecha mal introducido");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: No se ha encontrado el fichero al guardar");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: Tienes que introducir un valor");
		} catch (NumberFormatException  e) {
			// TODO Auto-generated catch block
			System.err.println("Error: No has introducido un numero");
		} 
		
		
	}

	private static Pelicula peliculaMasLarga(ArrayList<Pelicula> peliculas) {
		// TODO Auto-generated method stub
		DuracionComparator dc=new DuracionComparator();
		peliculas.sort(dc);
		Iterator<Pelicula> i =peliculas.iterator();
		return i.next();
	}

	private static void guardarLista(ArrayList<Pelicula> peliculas) throws IOException {
		// TODO Auto-generated method stub
		
		Pelicula peli=new Pelicula();
			PrintWriter printWriter =peli.crearPWriter();
			
			Iterator<Pelicula> it =peliculas.iterator();
			while (it.hasNext()){
				Pelicula p =it.next();
				printWriter.print(p.getTitulo()+":"+p.getDuracion()+":");
				printWriter.print(p.getDirector().getNombre()+" "+p.getDirector().getApellido()+":");
				for (int i = 0; i < p.getActores().length; i++) {
					printWriter.print(p.getActores()[i].getNombre()+" "+p.getActores()[i].getApellido());
					if (i!=p.getActores().length-1){
						printWriter.print(",");
					}
				}
				printWriter.print(":"+p.getValoracion());
				printWriter.println(":"+formatter.format(p.getFecha_estreno()));
				
			}
			peli.cerrarFWriter();
			
		 
		
	}
	
	

	private static void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
		// TODO Auto-generated method stub
		Iterator<Pelicula> i=peliculas.iterator();
		
		while(i.hasNext()){
			i.next().mostrarInfo();
		}
	}

	

	

}
