package io.swagger.configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.model.*;


public class Utilities {
	
	private Hashtable<String, Cliente> clientePersistence;
	private Hashtable<String,Contrato> contratoPersistence;
	private Hashtable<String,Inmueble> inmueblePersistence;
	
	public Utilities () {
		
		clientePersistence = new Hashtable<String, Cliente>();
		contratoPersistence = new Hashtable<String,Contrato>();
		inmueblePersistence = new Hashtable<String,Inmueble> ();
		
		
		clientePersistence.put("123456789", new Cliente("123456789","Cedula","Carlos","Laureles","555"));
		clientePersistence.put("3245678", new Cliente("3245678","Cedula","Andres","Poblado","6666"));
		clientePersistence.put("23457888", new Cliente("23457888","Cedula","Ana Sofia","Castillo","44444"));

		
		inmueblePersistence.put("1", new Inmueble("1", "Apartamento", "Carrera 80 b # 34 c - 04", "Medellìn", 4, BigDecimal.valueOf(1400000), 
				"3 habitaciones, dos baños, cocina integral, garage cubierto, "));
		inmueblePersistence.put("2", new Inmueble("2", "Casa", "Carrera 70 b # 35 c - 04", "Medellìn", 3, BigDecimal.valueOf(1100000), 
				"3 habitaciones, dos baños, cocina integral, garage cubierto, "));
		inmueblePersistence.put("2", new Inmueble("3", "Apartamento", "Carrera 80 b # 84 c - 04", "Medellìn", 5, BigDecimal.valueOf(950000), 
				"4 habitaciones, dos baños, cocina integral, garage compartido, "));
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
	
	// inmuebles
	
	public List<Inmueble> getInmuebles() {
		
		List<Inmueble> inmuebles = new ArrayList<Inmueble>(inmueblePersistence.values());
		return inmuebles;
	} 
	
	public void addInmueble(Inmueble inmuebleRequest) {
		
		this.inmueblePersistence.put(inmuebleRequest.getIdInmueble(), inmuebleRequest);
		
	}
	
	public Inmueble buscarInmueble(String id) {
		
		return inmueblePersistence.get(id);
	}
	
	public Inmueble actualizarInmueble(Inmueble inmuebleRequest,String id) {
		
		Inmueble inmuebleOriginal = inmueblePersistence.get(id);
		
		inmuebleOriginal.setCiudad(inmuebleRequest.getCiudad());
		inmuebleOriginal.setDetalles(inmuebleRequest.getDetalles());
		inmuebleRequest.setDireccion(inmuebleRequest.getDireccion());
		inmuebleRequest.setEstrato(inmuebleRequest.getEstrato());
		inmuebleRequest.setTipoInmueble(inmuebleRequest.getTipoInmueble());

		inmueblePersistence.put(id, inmuebleRequest);
		
		return inmuebleRequest;
		
	}
	
	public Inmueble eliminarInmueble(String id) {
		
		Inmueble inmuebles = inmueblePersistence.get(id);
		clientePersistence.remove(id);
		
		return inmuebles;
	}
	
	// Crear contrato
	
	public void addContrato(Contrato contratoRequest) {
		
		this.contratoPersistence.put(contratoRequest.getIdContrato(), contratoRequest);
		
	}
	
	public Contrato buscarContrato(String id) {
		
		return contratoPersistence.get(id);
	}
	
	public Contrato eliminarContrato(String id) {
		
		Contrato contrato = contratoPersistence.get(id);
		clientePersistence.remove(id);
		
		return contrato;
	}

}
