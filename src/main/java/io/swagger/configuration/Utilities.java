package io.swagger.configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import io.swagger.model.Cliente;
import io.swagger.model.Contrato;
import io.swagger.model.Inmueble;


public class Utilities {
	
	private Hashtable<String, Cliente> clientePersistence;
	private Hashtable<String,Contrato> contratoPersistence;
	private Hashtable<String,Inmueble> inmueblePersistence;
	
	public Utilities () {
		
		clientePersistence = new Hashtable<String, Cliente>();
		contratoPersistence = new Hashtable<String,Contrato>();
		inmueblePersistence = new Hashtable<String,Inmueble> ();
		
		
		
		clientePersistence.put("c1", new Cliente("c1","Cedula","Carlos","Laureles","555"));
		clientePersistence.put("c2", new Cliente("c2","Cedula","Andres","Poblado","6666"));
		clientePersistence.put("c3", new Cliente("c3","Cedula","Ana Sofia","Castillo","44444"));

		contratoPersistence.put("contrato1", new Contrato("contrato1","arriendo", "05-07-2018","05-12-2018","libre", "ninguna", "c1","inm1"));
		contratoPersistence.put("contrato3", new Contrato("contrato3","venta", "05-07-2018","05-12-2018","libre", "ninguna", "c1","inm3"));
		contratoPersistence.put("contrato2", new Contrato("contrato2","arriendo", "05-01-2018","05-06-2019","libre", "ninguna", "c2","inm2"));
		
		inmueblePersistence.put("inm1", new Inmueble("inm1", "Apartamento", "Carrera 80 b # 34 c - 04", "Medellìn", 4, BigDecimal.valueOf(1400000), 
				"3 habitaciones, dos baños, cocina integral, garage cubierto, "));
		inmueblePersistence.put("inm2", new Inmueble("inm2", "Casa", "Carrera 70 b # 35 c - 04", "Medellìn", 3, BigDecimal.valueOf(1100000), 
				"3 habitaciones, dos baños, cocina integral, garage cubierto, "));
		inmueblePersistence.put("inm3", new Inmueble("inm3", "Apartamento", "Carrera 80 b # 84 c - 04", "Medellìn", 5, BigDecimal.valueOf(950000), 
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
	
	public List<Contrato> buscarContratoPorCliente(String idCliente) {
		
		Enumeration e = contratoPersistence.keys();
		List<Contrato> listaContrato = new ArrayList<>();
		while(e.hasMoreElements()) {
			Contrato contrato = contratoPersistence.get(e.nextElement());
			if(contrato.getIdCiente().equals(idCliente)) {
				listaContrato.add(contrato);
			}
		}
		
		return listaContrato;
	}
	
	public List<Contrato> buscarContratoPorInmueble(String idInmueble) {
		
		Enumeration e = contratoPersistence.keys();
		List<Contrato> listaInmueble = new ArrayList<>();
		while(e.hasMoreElements()) {
			Contrato contrato = contratoPersistence.get(e.nextElement());
			if(contrato.getIdInmueble().equals(idInmueble)) {
				listaInmueble.add(contrato);
			}
		}
		
		return listaInmueble;
	}

}
