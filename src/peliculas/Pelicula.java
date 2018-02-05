package peliculas;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pelicula extends Video implements Mostrator, Serializable{
	
	private static final long serialVersionUID=1000;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Persona director;
	private Persona[] actores;
	private double valoracion;
	private Date fecha_estreno;
	
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
		
	public void mostrarActores(){
		System.out.print("Actores: ");
		for (int i = 0; i < this.actores.length; i++) {
			Persona actor=this.getActores()[i];
			actor.mostrarPersona();
			if (i!=this.actores.length-1){
				System.out.print(",");
			}
		}
	}
	
	public void anadirActores(String[] linea){
		Persona[] actores=new Persona[linea.length];
		for (int i = 0; i < actores.length; i++) {
			String[] na=linea[i].split(" ");
			Persona actor=new Persona(na[0],na[1]);
			actores[i]=actor;
		}
		this.setActores(actores);
	}
	
	
	public void editarPelicula() throws ParseException{
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
	
}
