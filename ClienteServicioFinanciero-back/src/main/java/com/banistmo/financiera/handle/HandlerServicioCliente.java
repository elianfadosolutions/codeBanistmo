package com.banistmo.financiera.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.banistmo.financiera.dto.ClienteDTO;
import com.banistmo.financiera.dto.ClienteServicioDTO;
import com.banistmo.financiera.requests.RequestCliente;
import com.banistmo.financiera.requests.RequestServicioCliente;

public class HandlerServicioCliente implements RequestHandler <RequestServicioCliente, Object>{

	@Override
	public Object handleRequest(RequestServicioCliente request, Context context) {
		// TODO Auto-generated method stub
		AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        List<ClienteServicioDTO> clienteServicio= null;
        
        switch(request.getHttpMethod()){
        	case "GET":
        		List<ClienteDTO> clientes = mapper.scan(ClienteDTO.class, new DynamoDBScanExpression());
        		//CONSULTAR 1)CUENTA DE AHORRO
        		List<ClienteDTO> clientesCuentaAhorro = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getCiudad()!=null&&cliente.getCiudad().toLowerCase().equals("panamá")&& cliente.getEdad()>=18) {
        				clientesCuentaAhorro.add(cliente);
        			}
        		}
        		//CONSULTAR 2)TARJETA DE DEBITO
        		List<ClienteDTO> clientesTarjetaDebito = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getCiudad()!=null&&cliente.getCiudad().toLowerCase().equals("panamá")&& 
        					cliente.getEdad()>=18&&cliente.getIngresos()>=500) {
        				clientesTarjetaDebito.add(cliente);
        			}
        		}
        		//CONSULTAR 1)TARJETA DE CRÉDITO
        		List<ClienteDTO> clientesTarjetaCredito = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getCiudad()!=null&&cliente.getCiudad().toLowerCase().equals("panamá")&& 
        					cliente.getEdad()>=20&&cliente.getIngresos()>=1500) {
        				clientesTarjetaCredito.add(cliente);
        			}
        		}
        		//CONSULTAR 4) SEGURO
        		List<ClienteDTO> clientesSeguros = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getEdad()>=15&&cliente.getIngresos()>=1000) {
        				clientesSeguros.add(cliente);
        			}
        		}
        		//CONSULTAR 5)INVERSIONES
        		List<ClienteDTO> clientesInversiones = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getEdad()>=25&&cliente.getIngresos()>=4500) {
        				clientesInversiones.add(cliente);
        			}
        		}
        		//CONSULTAR 6)GIROS
        		List<ClienteDTO> clientesGiros = new ArrayList<ClienteDTO>();
        		for(ClienteDTO cliente:clientes) {
        			if(cliente.getCiudad()!=null&&cliente.getCiudad().toLowerCase().equals("panamá")) {
        				clientesGiros.add(cliente);
        			}
        		}
        		Map<String,ClienteServicioDTO> clienteServicioMap = new HashMap<String, ClienteServicioDTO>();
        		
        		for(ClienteDTO clienteMap: clientesInversiones) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("INVERSION", clienteMap));
        		}
        		
        		for(ClienteDTO clienteMap: clientesTarjetaCredito) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("TARJETAS DE CREDITO", clienteMap));
        		}
        		
        		for(ClienteDTO clienteMap: clientesTarjetaDebito) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("TARJETAS DE DEBITO", clienteMap));
        		}
        		
        		for(ClienteDTO clienteMap: clientesCuentaAhorro) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("CUENTAS DE AHORROS", clienteMap));
        		}
        		
        		for(ClienteDTO clienteMap: clientesSeguros) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("SEGUROS", clienteMap));
        		}
        		
        		for(ClienteDTO clienteMap: clientesGiros) {
        			clienteServicioMap.put(clienteMap.getCodigo(), new ClienteServicioDTO("GIROS", clienteMap));
        		}
        		clienteServicio= new ArrayList<ClienteServicioDTO>(clienteServicioMap.values());
        }
        		
		return clienteServicio;
	}

}
