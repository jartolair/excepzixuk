package peliculas;

import java.util.Date;

public class Persona {
//atributos private
	private String nombre;
	private String apellido;
	private int edad;
	private Date Fecha_nacimiento;
	private String poblacion;
	private String telefono;
	private String nacionalidad;
	private String direccion;
	private String DNI;
	
	private double dinero;
	public double peso;

	/**
	 * crear objeto persona
	 */
	public Persona(){
		
	}
	/**
	 * crear objeto persona con todos sus atributos
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param fecha_nacimiento
	 * @param poblacion
	 * @param telefono
	 * @param nacionalidad
	 * @param direccion
	 * @param dNI
	 * @param dinero
	 * @param peso
	 * @param cuenta
	 */
	public Persona(String nombre, String apellido, int edad, Date fecha_nacimiento, String poblacion, String telefono,
			String nacionalidad, String direccion, String dNI, double dinero, double peso) {
		//super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		Fecha_nacimiento = fecha_nacimiento;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		DNI = dNI;
		this.dinero = dinero;
		this.peso = peso;
	}
	
	

	public Persona(String nombre, String apellido, String dni){
		this.nombre=nombre;
		this.apellido=apellido;
		this.DNI=dni;
	}
	
	public Persona(String nombre, String apellido){
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public void mostrarPersona(){
		System.out.print(this.getNombre()+ " "+this.getApellido());
	}
	
	
	/**
	 * @return the cuenta
	 */
	

	//metodos public
	public void comer(double pesoComida){
		this.engordar(pesoComida);
		System.out.println("He comido");
		
	}
	
	public void correr(int minutos){
		//por cada minuto 0.001 gramo

		double peso_perdido=minutos*0.001;
		this.peso=(this.peso-peso_perdido);
	}
	
	public void gastarDinero(double cantidad){
		if (cantidad>this.dinero){
			System.out.println("No lo puedes comprar");
		}else{
			setDinero(this.dinero-cantidad);
		}
	}
	
	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public void correr(double km){
		double pesoPerdido=0.05*km;
		this.peso=this.peso-pesoPerdido;
		System.out.println("He corrido "+ km+"km y he perdido "+pesoPerdido+"kg");
	}
	
	/*
	 * @param peso en cuanto se va a cambiar el peso
	 */
	public void engordar(double peso){
		this.peso=this.peso+peso;
	}
	
	public void cambiarEdad(int edad){
		this.edad=edad;
	}
	


	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(this.edad<0){
			System.out.println("Error: el edad no pede estar en negativo");
		}else{
			this.edad = edad;
		}
	}

	public Date getFecha_nacimiento() {
		return Fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		Fecha_nacimiento = fecha_nacimiento;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (
			telefono.length()!=9){
			System.out.println("Error: telefono mal introduicido");
		}else{
			this.telefono = telefono;
		}
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		if (dNI.length()!=9){
			System.out.println("Error: dni mal introduicido");
		}else{
			this.DNI = dNI;
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		if(this.peso<0){
			System.out.println("Error: el peso no pede estar en negativo");
		}else{
			this.peso = peso;
		}
	}
	
	public String getStringGuardado() {
		return this.getNombre() + "," +this.getApellido() +"," + this.getTelefono()+"," + this.getDNI();
	}

	

	
	

	
	
	
	
	
	
	

}//fin clase persona
