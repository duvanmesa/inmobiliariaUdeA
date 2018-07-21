package io.swagger.api;

import io.swagger.model.Cliente;
import io.swagger.model.Contrato;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.configuration.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
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

    public ResponseEntity<List<Contrato>> obtenerContratosCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
       

        return new ResponseEntity<List<Contrato>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> registrarCliente(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cliente body) {
        
    	utilities.addCliente(body);
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);

        return new ResponseEntity<String>("Cliente registrado exitosamente!!",responseHeaders,HttpStatus.CREATED);
    }

}
