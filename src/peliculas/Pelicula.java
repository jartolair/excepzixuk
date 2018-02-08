package peliculas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Pelicula extends Video implements Mostrator{
	
	private String nombreFichero="C:/Users/Artola/Desktop/pelikulak.txt";	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Persona director;
	private Persona[] actores;
	private double valoracion;
	private Date fecha_estreno;
	private FileWriter fileWriter;
	private String[] razonesDeQueSeaBueno;
	
	public Pelicula(){
		super();
	}
	
	public Pelicula(String titulo, double duracion, Persona director, Persona[] actores) {
		super(titulo,duracion);
		this.director = director;
		this.actores = actores;
	}

	@Override
	public void mostrarInfo() {
		System.out.println("------------PELICULA----------");
		System.out.println("Titulo: "+this.getTitulo());
		System.out.print("Director: ");
		this.getDirector().mostrarPersona();
		System.out.println();
		this.mostrarActores();
		System.out.println();
		System.out.println("Duracion: "+this.getDuracion()+"mins");
		System.out.println("Valoracion: "+this.getValoracion());
		System.out.println("Fecha de estreno: "+formatter.format(this.getFecha_estreno()));
		
		
	}
	
	

	
	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}


	public Date getFecha_estreno() {
		return fecha_estreno;
	}

	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}

	public Persona getDirector() {
		return director;
	}

	public void setDirector(Persona director) {
		this.director = director;
	}

	public Persona[] getActores() {
		return actores;
	}

	public void setActores(Persona[] actores) {
		this.actores = actores;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	
	
		
	public String[] getRazonesDeQueSeaBueno() {
		return razonesDeQueSeaBueno;
	}

	public void setRazonesDeQueSeaBueno(String[] razonesDeQueSeaBueno) {
		this.razonesDeQueSeaBueno = razonesDeQueSeaBueno;
	}

	public void mostrarActores() throws NullPointerException{
		System.out.print("Hay "+this.getActores().length+" actores: ");
		for (int i = 0; i < this.actores.length; i++) {
			Persona actor=this.getActores()[i];
			actor.mostrarPersona();
			if (i!=this.actores.length-1){
				System.out.print(",");
			}
		}
	}
	
	public void anadirActores(String[] linea)throws ArrayIndexOutOfBoundsException{
		Persona[] actores=new Persona[linea.length];
		for (int i = 0; i < actores.length; i++) {
			String[] na=linea[i].split(" ");
			Persona actor=new Persona(na[0],na[1]);
			actores[i]=actor;
		}
		this.setActores(actores);
	}
	
	
	public void editarPelicula() throws ParseException,NumberFormatException{
		Scanner lector=new Scanner(System.in);
		
		System.out.println("Nuevo titulo de la pelicula: <"+this.getTitulo()+">");
		this.setTitulo(lector.nextLine());
		
		System.out.println("Nueva duracion de la pelicula: <"+this.getDuracion()+">");
		this.setDuracion(Double.parseDouble(lector.nextLine()));
		
		System.out.print("Nuevo director de la pelicula: [Nombre Apellido] <");
		this.getDirector().mostrarPersona();
		System.out.println(">");
		String[] director=lector.nextLine().split(" ");
		this.setDirector(new Persona(director[0],director[1]));
		
		System.out.print("Nuevos actores de la pelicula: [Nombre Apellido],[Nombre Apellido] <");
		this.mostrarActores();
		System.out.println(">");
		String actores=lector.nextLine();
		this.anadirActores(actores.split(","));
		
		System.out.println("Nueva valoracion de la pelicula: <"+this.getValoracion()+">");
		this.valoracion=Double.parseDouble(lector.nextLine());
		
		System.out.println("Nueva fecha de estreno: [DD/MM/YYYY] <"+formatter.format(this.getFecha_estreno())+">");
		this.fecha_estreno=formatter.parse(lector.nextLine());
		
		
	}

	public Scanner crearLectorF() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f= new File(this.nombreFichero);
		Scanner scan= new Scanner(f);
		return scan;
	}

	public PrintWriter crearPWriter() throws IOException {
		// TODO Auto-generated method stub
		
		this.fileWriter=new FileWriter(this.getNombreFichero());
		return new PrintWriter(fileWriter);
		
		
	}

	public void cerrarFWriter() throws IOException {
		// TODO Auto-generated method stub
		this.fileWriter.close();
	}
	
	
	public Double duracionEnHoras(){
		return (this.getDuracion()/60);
	}
	
	public Double calcularValor() throws NullPointerException{
		Double valor=this.valoracion;
		for (int i = 0; i < this.razonesDeQueSeaBueno.length; i++) {
			switch(this.razonesDeQueSeaBueno[i]){
			case "director famoso":
				valor=valor+7.5;
				break;
			case "actor famoso":
				valor=valor+7.5;
				break;
			case "director muerto":
				valor=valor+9;
				break;
			case "actor muerto":
				valor=valor+9;
				break;
			case "premio importante":
				valor=valor+8.5;
				break;
			case "premio normal":
				valor=valor+3.5;
				break;
			}
		}
		return valor;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
