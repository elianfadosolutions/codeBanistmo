package com.banistmo.financiera.handle;


import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.banistmo.financiera.dto.ClienteDTO;
import com.banistmo.financiera.requests.RequestCliente;

public class HandlerCliente implements RequestHandler <RequestCliente, Object>{

	@Override
	public Object handleRequest(RequestCliente request, Context context) {
		AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        ClienteDTO cliente = null;

        switch(request.getHttpMethod()){
            case "GET":
                if(request.getCodigo()==null){
                    List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
                    clientes = mapper.scan(ClienteDTO.class, new DynamoDBScanExpression());
                    return clientes;
                }else{
                    cliente = mapper.load(ClienteDTO.class, request.getCodigo());
                    return cliente;
                }
            case "POST":
                cliente = request.getCliente();
                ClienteDTO clienteOLD = mapper.load(ClienteDTO.class, request.getCodigo());
                
                if(request.getTipoUsuario()!=null&&request.getTipoUsuario().toLowerCase().equals("cliente") 
                		&& clienteOLD==null) {
                    mapper.save(cliente);
                    return cliente;
                }else if(request.getTipoUsuario()!=null&&request.getTipoUsuario().toLowerCase().equals("comercial") 
                		&& clienteOLD!=null) {
                	clienteOLD.setIngresos(cliente.getIngresos());
                	clienteOLD.setCiudad(cliente.getCiudad());
                	clienteOLD.setEdad(cliente.getEdad());
                    mapper.save(clienteOLD);
                    return clienteOLD;
                }
        }
		return null;
	}

}
