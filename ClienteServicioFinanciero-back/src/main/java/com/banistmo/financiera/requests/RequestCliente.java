package com.banistmo.financiera.requests;

import com.banistmo.financiera.dto.ClienteDTO;

public class RequestCliente {
	
	private String codigo;
	
	private String HttpMethod;
	
	private String tipoUsuario;
	
	private ClienteDTO cliente;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getHttpMethod() {
		return HttpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		HttpMethod = httpMethod;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
