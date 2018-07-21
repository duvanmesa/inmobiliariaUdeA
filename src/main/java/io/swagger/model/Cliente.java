package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Persona que alquila los inmuebles por medio de la inmobiliaria.
 */
@ApiModel(description = "Persona que alquila los inmuebles por medio de la inmobiliaria.")
@Validated

public class Cliente   {
  @JsonProperty("idCliente")
  private String idCliente = null;

  @JsonProperty("tipoDocumento")
  private String tipoDocumento = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("direccion")
  private String direccion = null;

  @JsonProperty("telefono")
  private String telefono = null;

  public Cliente idCliente(String idCliente) {
    this.idCliente = idCliente;
    return this;
  }

  /**
   * Codigo del documento de identidad del cliente
   * @return idCliente
  **/
  @ApiModelProperty(required = true, value = "Codigo del documento de identidad del cliente")
  @NotNull


  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  public Cliente tipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
    return this;
  }

  /**
   * Tipo de documento de identidad
   * @return tipoDocumento
  **/
  @ApiModelProperty(required = true, value = "Tipo de documento de identidad")
  @NotNull


  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public Cliente nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del cliente
   * @return nombre
  **/
  @ApiModelProperty(required = true, value = "Nombre del cliente")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Cliente direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Dirección del cliente o familiares
   * @return direccion
  **/
  @ApiModelProperty(required = true, value = "Dirección del cliente o familiares")
  @NotNull


  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Cliente telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Telefono del cliente
   * @return telefono
  **/
  @ApiModelProperty(required = true, value = "Telefono del cliente")
  @NotNull


  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.idCliente, cliente.idCliente) &&
        Objects.equals(this.tipoDocumento, cliente.tipoDocumento) &&
        Objects.equals(this.nombre, cliente.nombre) &&
        Objects.equals(this.direccion, cliente.direccion) &&
        Objects.equals(this.telefono, cliente.telefono);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, tipoDocumento, nombre, direccion, telefono);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

