package com.client.rest.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.helpers.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.client.rest.models.Cliente;
import com.google.gson.Gson;

public class ClienteServiceImpl {
	
	private static final String PATH_API = "http://localhost:8080/serviceREST-JAX-RS/api/v1/clientes";
	
	/**
	 * Metodo para obtener todos los clientes
	 * GET /clientes
	 * @return
	 * @throws ClientProtocolException, IOException 
	 */
	public List<Cliente> getClients() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getResourceClients = new HttpGet(PATH_API);
		HttpResponse response = httpclient.execute(getResourceClients);
		//InputStream se procede a convertir a String
		String clientsString = IOUtils.toString(response.getEntity().getContent());
		//String se convierte a Arreglo de tipo Cliente
		Cliente[]  clientes = new Gson().fromJson(clientsString, Cliente[].class);
		//Se cierra conexion a la peticion
		httpclient.close();
		return Arrays.asList(clientes);
	}
	
	/**
	 * Metodo para obtener un cliente por id
	 * GET /clientes/{id}
	 * @param id
	 * @return
	 * @throws ClientProtocolException, IOException 
	 */
	public Cliente getClient(int id) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getResourceClient = new HttpGet(PATH_API + "/" + String.valueOf(id));
		HttpResponse response = httpclient.execute(getResourceClient);
		String clientString = IOUtils.toString(response.getEntity().getContent());
		Cliente cliente = new Gson().fromJson(clientString, Cliente.class);
		httpclient.close();
		return cliente;
	}
	
	/**
	 * Metodo para crear un nuevo cliente
	 * POST /clientes
	 * @param cliente
	 * @return
	 * @throws ClientProtocolException, IOException 
	 */
	public String saveClient(Cliente cliente) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost saveClient = new HttpPost(PATH_API);
		saveClient.setHeader("Content-Type", MediaType.APPLICATION_JSON);
		String jsonClient = new Gson().toJson(cliente);
		StringEntity entityCliente = new StringEntity(jsonClient);
		saveClient.setEntity(entityCliente);
		HttpResponse responseClient = httpclient.execute(saveClient);
		String clientString = IOUtils.toString(responseClient.getEntity().getContent());
		httpclient.close();
		return clientString;
		
	}
	
	/**
	 * Metodo para actualizar un cliente por id
	 * PUT /clientes/{id}
	 * @param id
	 * @param cliente
	 * @return
	 * @throws ClientProtocolException, IOException 
	 */
	public String updateClient(int id, Cliente cliente) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut updateClient = new HttpPut(PATH_API + "/" + String.valueOf(id));
		updateClient.setHeader("Content-Type", MediaType.APPLICATION_JSON);
		String jsonClient = new Gson().toJson(cliente);
		StringEntity entityCliente = new StringEntity(jsonClient);
		updateClient.setEntity(entityCliente);
		HttpResponse responseClient = httpclient.execute(updateClient);
		String clientString = IOUtils.toString(responseClient.getEntity().getContent());
		httpclient.close();
		return clientString;
	}
	
	/**
	 * Metodo para eliminar un cliente por id
	 * DELETE /clientes/{id}
	 * @param id
	 * @return
	 * @throws ClientProtocolException, IOException
	 */
	public String deleteClient(int id) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete deleteClient = new HttpDelete(PATH_API + "/" + String.valueOf(id));
		HttpResponse responseClient = httpclient.execute(deleteClient);
		String clientString = IOUtils.toString(responseClient.getEntity().getContent());
		httpclient.close();
		return clientString;	
	}
}
