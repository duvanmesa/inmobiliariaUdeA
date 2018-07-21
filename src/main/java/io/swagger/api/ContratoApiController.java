package io.swagger.api;

import io.swagger.model.Contrato;
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
public class ContratoApiController implements ContratoApi {

    private static final Logger log = LoggerFactory.getLogger(ContratoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContratoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> crearContrato(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Contrato body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("text/plain")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"Contrato creado exitosamente!\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type text/plain", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Contrato> eliminarContrato(@ApiParam(value = "",required=true) @PathVariable("idContrato") String idContrato) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Contrato>(objectMapper.readValue("{  \"idInmueble\" : \"idInmueble\",  \"fechaInicio\" : \"2000-01-23\",  \"clausula\" : \"clausula\",  \"tipoContrato\" : \"tipoContrato\",  \"idContrato\" : \"idContrato\",  \"fechaFin\" : \"2000-01-23\",  \"idCiente\" : \"idCiente\",  \"Estado\" : \"Estado\"}", Contrato.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Contrato>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Contrato> obtenerContrato(@ApiParam(value = "",required=true) @PathVariable("idContrato") String idContrato) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Contrato>(objectMapper.readValue("{  \"idInmueble\" : \"idInmueble\",  \"fechaInicio\" : \"2000-01-23\",  \"clausula\" : \"clausula\",  \"tipoContrato\" : \"tipoContrato\",  \"idContrato\" : \"idContrato\",  \"fechaFin\" : \"2000-01-23\",  \"idCiente\" : \"idCiente\",  \"Estado\" : \"Estado\"}", Contrato.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Contrato>(HttpStatus.NOT_IMPLEMENTED);
    }

}
