package peliculas;

public abstract class Video {
	
	private String titulo;
	private double duracion;
	
	public Video(String titulo2, double duracion2) {
		// TODO Auto-generated constructor stub
		this.titulo=titulo2;
		this.duracion=duracion2;
	}

	public Video(){
		
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	
	
	
	

}
