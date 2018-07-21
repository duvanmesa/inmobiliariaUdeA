package io.swagger.api;

import io.swagger.model.Contrato;
import io.swagger.model.Inmueble;
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
public class InmuebleApiController implements InmuebleApi {

    private static final Logger log = LoggerFactory.getLogger(InmuebleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private Utilities utilities;

    
    @org.springframework.beans.factory.annotation.Autowired
    public InmuebleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Inmueble> actualizarInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Inmueble body) {
       
    	
    	Inmueble inmueble = utilities.actualizarInmueble(body, idInmueble);
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);


        return new ResponseEntity<Inmueble>(inmueble,responseHeaders,HttpStatus.OK);
  
    }

    public ResponseEntity<Inmueble> eliminarInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble) {

		Inmueble inmueble = utilities.eliminarInmueble(idInmueble);
        
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        
        return new ResponseEntity<Inmueble>(inmueble,responseHeaders,HttpStatus.OK);    	
    	
    }

    public ResponseEntity<List<Inmueble>> listarInmueble() {
    	
		List<Inmueble> inmueble = utilities.getInmuebles();
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);

        return new ResponseEntity<List<Inmueble>>(inmueble,responseHeaders,HttpStatus.OK);    	
    }

    public ResponseEntity<List<Contrato>> obtenerContratosInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Contrato>>(objectMapper.readValue("[ {  \"idInmueble\" : \"idInmueble\",  \"fechaInicio\" : \"2000-01-23\",  \"clausula\" : \"clausula\",  \"tipoContrato\" : \"tipoContrato\",  \"idContrato\" : \"idContrato\",  \"fechaFin\" : \"2000-01-23\",  \"idCiente\" : \"idCiente\",  \"Estado\" : \"Estado\"}, {  \"idInmueble\" : \"idInmueble\",  \"fechaInicio\" : \"2000-01-23\",  \"clausula\" : \"clausula\",  \"tipoContrato\" : \"tipoContrato\",  \"idContrato\" : \"idContrato\",  \"fechaFin\" : \"2000-01-23\",  \"idCiente\" : \"idCiente\",  \"Estado\" : \"Estado\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Contrato>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Inmueble> obtenerInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble) {

		Inmueble inmueble = utilities.buscarInmueble(idInmueble);
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        return new ResponseEntity<Inmueble>(inmueble,responseHeaders,HttpStatus.OK);
        
    }

    public ResponseEntity<String> registrarInmueble(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Inmueble body) {

		utilities.addInmueble(body);
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);

        return new ResponseEntity<String>("Inmueble registrado exitosamente!!",responseHeaders,HttpStatus.CREATED);
    
    }

}
