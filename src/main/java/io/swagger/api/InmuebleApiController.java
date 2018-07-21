package io.swagger.api;

import io.swagger.model.Contrato;
import io.swagger.model.Inmueble;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @org.springframework.beans.factory.annotation.Autowired
    public InmuebleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Inmueble> actualizarInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Inmueble body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Inmueble>(objectMapper.readValue("{  \"idInmueble\" : \"idInmueble\",  \"ciudad\" : \"ciudad\",  \"direccion\" : \"direccion\",  \"valor\" : 6.02745618307040320615897144307382404804229736328125,  \"tipoInmueble\" : \"tipoInmueble\",  \"estrato\" : 0,  \"detalles\" : \"detalles\"}", Inmueble.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Inmueble>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Inmueble>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Inmueble> eliminarInmueble(@ApiParam(value = "",required=true) @PathVariable("idInmueble") String idInmueble) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Inmueble>(objectMapper.readValue("{  \"idInmueble\" : \"idInmueble\",  \"ciudad\" : \"ciudad\",  \"direccion\" : \"direccion\",  \"valor\" : 6.02745618307040320615897144307382404804229736328125,  \"tipoInmueble\" : \"tipoInmueble\",  \"estrato\" : 0,  \"detalles\" : \"detalles\"}", Inmueble.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Inmueble>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Inmueble>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Inmueble>> listarInmueble() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Inmueble>>(objectMapper.readValue("[ {  \"idInmueble\" : \"idInmueble\",  \"ciudad\" : \"ciudad\",  \"direccion\" : \"direccion\",  \"valor\" : 6.02745618307040320615897144307382404804229736328125,  \"tipoInmueble\" : \"tipoInmueble\",  \"estrato\" : 0,  \"detalles\" : \"detalles\"}, {  \"idInmueble\" : \"idInmueble\",  \"ciudad\" : \"ciudad\",  \"direccion\" : \"direccion\",  \"valor\" : 6.02745618307040320615897144307382404804229736328125,  \"tipoInmueble\" : \"tipoInmueble\",  \"estrato\" : 0,  \"detalles\" : \"detalles\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Inmueble>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Inmueble>>(HttpStatus.NOT_IMPLEMENTED);
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Inmueble>(objectMapper.readValue("{  \"idInmueble\" : \"idInmueble\",  \"ciudad\" : \"ciudad\",  \"direccion\" : \"direccion\",  \"valor\" : 6.02745618307040320615897144307382404804229736328125,  \"tipoInmueble\" : \"tipoInmueble\",  \"estrato\" : 0,  \"detalles\" : \"detalles\"}", Inmueble.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Inmueble>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Inmueble>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> registrarInmueble(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Inmueble body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("text/plain")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"Inmueble registrado exitosamente!\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type text/plain", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
