package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Utilities;
import io.swagger.model.Cliente;
import io.swagger.model.Contrato;

@RestController
public class ClienteApiController implements ClienteApi {

    private static final Logger log = LoggerFactory.getLogger(ClienteApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private Utilities utilities;

    @org.springframework.beans.factory.annotation.Autowired
    public ClienteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Cliente> actualizarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cliente body) {
       
    	Cliente cliente = utilities.actualizarCliente(body, idCliente);
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);


        return new ResponseEntity<Cliente>(cliente,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Cliente> buscarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
        
    	Cliente cliente = utilities.buscarCliente(idCliente);
    	
    	List<Contrato> linkBuilder = methodOn(ClienteApiController.class).obtenerContratosCliente(cliente.getIdCliente());
        Link contratosLink = linkTo(linkBuilder).withRel("todosContratos");
        cliente.add(contratosLink);
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        return new ResponseEntity<Cliente>(cliente,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Cliente> eliminaruscarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
       
    	Cliente cliente = utilities.eliminarCliente(idCliente);
        
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        
        return new ResponseEntity<Cliente>(cliente,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<List<Cliente>> listarClientes() {
       
    	List<Cliente> clientes = utilities.getClientes();
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);


        return new ResponseEntity<List<Cliente>>(clientes,responseHeaders,HttpStatus.OK);
    }

    public List<Contrato> obtenerContratosCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
    	List<Contrato> lstResponse = utilities.buscarContratoPorCliente(idCliente);
        for(Contrato contrato:lstResponse){
            Link cotejoLink = linkTo(ContratoApi.class).slash(contrato.getIdContrato()).withSelfRel();
            contrato.add(cotejoLink);
        }
        return lstResponse; 
    }

    public ResponseEntity<String> registrarCliente(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cliente body) {
        
    	utilities.addCliente(body);
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);

        return new ResponseEntity<String>("Cliente registrado exitosamente!!",responseHeaders,HttpStatus.CREATED);
    }

}
