package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
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
import io.swagger.model.Contrato;
import io.swagger.model.Inmueble;

@RestController
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

    public List<Contrato> obtenerContratosInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble) {
    	List<Contrato> lstResponse = utilities.buscarContratoPorInmueble(idInmueble);
        for(Contrato contrato:lstResponse){
            Link cotejoLink = linkTo(ContratoApi.class).slash(contrato.getIdContrato()).withSelfRel();
            contrato.add(cotejoLink);
        }
        return lstResponse;
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
