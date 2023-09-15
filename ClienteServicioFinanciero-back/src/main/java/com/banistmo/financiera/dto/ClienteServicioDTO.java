package com.banistmo.financiera.dto;


public class ClienteServicioDTO {
	private String codigo;
	private String nombre_completo;
	private String servicio;
	private long ingresos;
	private String ciudad;
	private int edad;
	
	public ClienteServicioDTO() {
	}

	public ClienteServicioDTO(String codigo, String nombre_completo, String servicio, long ingresos, String ciudad,
			int edad) {
		this.codigo = codigo;
		this.nombre_completo = nombre_completo;
		this.servicio = servicio;
		this.ingresos = ingresos;
		this.ciudad = ciudad;
		this.edad = edad;
	}
	public ClienteServicioDTO(String servicio, ClienteDTO cliente) {
		this.codigo=cliente.getCodigo(); 
		this.servicio=servicio;
		this.ingresos=cliente.getIngresos(); 
		this.ciudad=cliente.getCiudad();
		this.edad=cliente.getEdad();
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public long getIngresos() {
		return ingresos;
	}

	public void setIngresos(long ingresos) {
		this.ingresos = ingresos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
