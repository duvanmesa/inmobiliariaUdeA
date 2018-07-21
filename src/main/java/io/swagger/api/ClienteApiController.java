package io.swagger.api;

import io.swagger.model.Cliente;
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
public class ClienteApiController implements ClienteApi {

    private static final Logger log = LoggerFactory.getLogger(ClienteApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ClienteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Cliente> actualizarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cliente body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cliente>(objectMapper.readValue("{  \"tipoDocumento\" : \"tipoDocumento\",  \"idCliente\" : \"idCliente\",  \"direccion\" : \"direccion\",  \"telefono\" : \"telefono\",  \"nombre\" : \"nombre\"}", Cliente.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cliente> buscarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cliente>(objectMapper.readValue("{  \"tipoDocumento\" : \"tipoDocumento\",  \"idCliente\" : \"idCliente\",  \"direccion\" : \"direccion\",  \"telefono\" : \"telefono\",  \"nombre\" : \"nombre\"}", Cliente.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cliente> eliminaruscarCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cliente>(objectMapper.readValue("{  \"tipoDocumento\" : \"tipoDocumento\",  \"idCliente\" : \"idCliente\",  \"direccion\" : \"direccion\",  \"telefono\" : \"telefono\",  \"nombre\" : \"nombre\"}", Cliente.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Cliente>> listarClientes() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Cliente>>(objectMapper.readValue("[ {  \"tipoDocumento\" : \"tipoDocumento\",  \"idCliente\" : \"idCliente\",  \"direccion\" : \"direccion\",  \"telefono\" : \"telefono\",  \"nombre\" : \"nombre\"}, {  \"tipoDocumento\" : \"tipoDocumento\",  \"idCliente\" : \"idCliente\",  \"direccion\" : \"direccion\",  \"telefono\" : \"telefono\",  \"nombre\" : \"nombre\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Contrato>> obtenerContratosCliente(@ApiParam(value = "",required=true) @PathVariable("idCliente") String idCliente) {
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

    public ResponseEntity<String> registrarCliente(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Cliente body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("text/plain")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"Cliente registrado exitosamente!\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type text/plain", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
