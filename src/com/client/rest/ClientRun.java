package com.client.rest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.client.rest.service.ClienteServiceImpl;

public class ClientRun {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		ClienteServiceImpl c = new ClienteServiceImpl();
		c.getClients().forEach((cliente) -> {
			System.out.println(cliente);
		});
		System.out.println(c.getClient(2));
		
	}
}
