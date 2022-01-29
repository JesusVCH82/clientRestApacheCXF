package com.client.rest.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.cxf.helpers.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.client.rest.models.Cliente;
import com.google.gson.Gson;

public class ClienteServiceImpl {
	
	private static final String PATH_API = "http://192.168.1.80:8080/serviceREST-JAX-RS/api/v1/clientes";
	
	public List<Cliente> getClients() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getResourceClients = new HttpGet(PATH_API);
		HttpResponse response = httpclient.execute(getResourceClients);
		//InputStream se procede a convertir a String
		String clientsString = IOUtils.toString(response.getEntity().getContent());
		//String se convierte a Arreglo de tipo Cliente
		Cliente[]  clientes = new Gson().fromJson(clientsString, Cliente[].class);
		return Arrays.asList(clientes);
		
	}
	
	public Cliente getClient(int id) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getResourceClient = new HttpGet(PATH_API + "/" + String.valueOf(id));
		HttpResponse response = httpclient.execute(getResourceClient);
		String clientString = IOUtils.toString(response.getEntity().getContent());
		Cliente cliente = new Gson().fromJson(clientString, Cliente.class);
		return cliente;
	}
	
	public String saveClient(Cliente cliente) {
		return null;
		
	}
	
	public String updateClient(int id, Cliente cliente) {
		return null;

	}
	
	public String deleteClient(int id) {
		return null;
		
	}
}
