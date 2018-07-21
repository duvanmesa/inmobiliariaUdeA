package io.swagger.configuration;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.model.*;


public class Utilities {
	
	private Hashtable<String, Cliente> clientePersistence;
	private Hashtable<String,Contrato> contrato;
	private Hashtable<String,Inmueble> inmueble;
	
	public Utilities () {
		
		clientePersistence = new Hashtable<String, Cliente>();
		clientePersistence.put("123456789", new Cliente("123456789","Cedula","Carlos","Laureles","555"));
		clientePersistence.put("3245678", new Cliente("3245678","Cedula","Andres","Poblado","6666"));
		clientePersistence.put("23457888", new Cliente("23457888","Cedula","Ana Sofia","Castillo","44444"));
		contrato = new Hashtable<String,Contrato>();
		inmueble = new Hashtable<String,Inmueble> ();
	}
	public void addCliente(Cliente cliente) {
		
		this.clientePersistence.put(cliente.getIdCliente(), cliente);
		
	}
	
	public List<Cliente> getClientes() {
		
		List<Cliente> clientes = new ArrayList<Cliente>(clientePersistence.values());
		return clientes;
	}
	
	public Cliente buscarCliente(String id) {
		
		return clientePersistence.get(id);
	}
	
	public Cliente actualizarCliente(Cliente cliente,String id) {
		
		Cliente clienteOriginal = clientePersistence.get(id);
		
		clienteOriginal.setNombre(cliente.getNombre());
		clienteOriginal.setTelefono(cliente.getTelefono());
		clienteOriginal.setDireccion(cliente.getDireccion());
		clientePersistence.put(id, clienteOriginal);
		return clienteOriginal;
		
	}
	
	public Cliente eliminarCliente(String id) {
		
		Cliente cliente = clientePersistence.get(id);
		clientePersistence.remove(id);
		
		return cliente;
	}

}
