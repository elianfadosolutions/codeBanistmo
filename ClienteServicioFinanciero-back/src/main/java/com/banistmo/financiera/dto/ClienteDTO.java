package com.banistmo.financiera.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "cliente")
public class ClienteDTO {
	
	@DynamoDBHashKey
	private String codigo;
	@DynamoDBAttribute
	private String nombre_completo;
	@DynamoDBAttribute
	private String clave_acceso;
	@DynamoDBAttribute
	private long ingresos;
	@DynamoDBAttribute
	private String ciudad;
	@DynamoDBAttribute
	private int edad;
	
	public ClienteDTO() {
	}

	public ClienteDTO(String codigo, String nombre_completo, String clave_acceso) {
		this.codigo = codigo;
		this.nombre_completo = nombre_completo;
		this.clave_acceso = clave_acceso;
	}
	
	public ClienteDTO(String codigo, String nombre_completo, String clave_acceso, long ingresos, String ciudad,
			int edad) {
		this.codigo = codigo;
		this.nombre_completo = nombre_completo;
		this.clave_acceso = clave_acceso;
		this.ingresos = ingresos;
		this.ciudad = ciudad;
		this.edad = edad;
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

	public String getClave_acceso() {
		return clave_acceso;
	}

	public void setClave_acceso(String clave_acceso) {
		this.clave_acceso = clave_acceso;
	}

}
