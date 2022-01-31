package com.client.rest;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import com.client.rest.models.Cliente;
import com.client.rest.service.ClienteServiceImpl;

public class ClientRun {

	public static void main(String[] args) {
		ClienteServiceImpl clientService = new ClienteServiceImpl();
		Cliente client = new Cliente(1, "jesus", "vazquez", 28, "JVCH1112221234", "Hidalgo 62", "554431981");
		
		try {	
			//GET
			System.out.println("GET: " + clientService.getClient(1));
			
			//GET
			System.out.println("List of clients: ");
			clientService.getClients().forEach((cliente) -> System.out.println(cliente));
			
			//POST
			System.out.println("POST: " + clientService.saveClient(client));
		
			//PUT
			System.out.println("PUT: " + clientService.updateClient(1, client));
			
			//DELETE
			System.out.println("DELETE: " + clientService.deleteClient(1));	
			
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
