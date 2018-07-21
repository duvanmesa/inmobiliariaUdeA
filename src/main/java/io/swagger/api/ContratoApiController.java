package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Utilities;
import io.swagger.model.Cliente;
import io.swagger.model.Contrato;

@Controller
public class ContratoApiController implements ContratoApi {

    private static final Logger log = LoggerFactory.getLogger(ContratoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired                    
    private Utilities utilities;

    @org.springframework.beans.factory.annotation.Autowired
    public ContratoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> crearContrato(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Contrato body) {
    	utilities.addContrato(body);
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);

        return new ResponseEntity<String>("Contrato creado exitosamente!!",responseHeaders,HttpStatus.CREATED);
    }

    public ResponseEntity<Contrato> eliminarContrato(@ApiParam(value = "",required=true) @PathVariable("idContrato") String idContrato) {
    	Contrato contrato = utilities.eliminarContrato(idContrato);                   
        
    	HttpHeaders responseHeaders = new HttpHeaders();                          
    	responseHeaders.setExpires(1000);                                         
    	                                                                          
    	return new ResponseEntity<Contrato>(contrato,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Contrato> obtenerContrato(@ApiParam(value = "",required=true) @PathVariable("idContrato") String idContrato) {
    	Contrato contrato = utilities.buscarContrato(idContrato);                     
        
    	HttpHeaders responseHeaders = new HttpHeaders();                          
    	responseHeaders.setExpires(1000);                                         
    	return new ResponseEntity<Contrato>(contrato,responseHeaders,HttpStatus.OK);
    }

}
