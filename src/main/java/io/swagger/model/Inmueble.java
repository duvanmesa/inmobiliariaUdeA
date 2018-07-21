package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Propiedad que brinda la inmobiliaria para alquiler a sus clientes
 */
@ApiModel(description = "Propiedad que brinda la inmobiliaria para alquiler a sus clientes")
@Validated

public class Inmueble extends ResourceSupport   {
  @JsonProperty("idInmueble")
  private String idInmueble = null;

  @JsonProperty("tipoInmueble")
  private String tipoInmueble = null;

  @JsonProperty("direccion")
  private String direccion = null;

  @JsonProperty("ciudad")
  private String ciudad = null;

  @JsonProperty("estrato")
  private Integer estrato = null;

  @JsonProperty("valor")
  private BigDecimal valor = null;

  @JsonProperty("detalles")
  private String detalles = null;
  
  
  
  public Inmueble(String idInmueble, String tipoInmueble, String direccion, String ciudad, Integer estrato,
		BigDecimal valor, String detalles) {
	super();
	this.idInmueble = idInmueble;
	this.tipoInmueble = tipoInmueble;
	this.direccion = direccion;
	this.ciudad = ciudad;
	this.estrato = estrato;
	this.valor = valor;
	this.detalles = detalles;
  }

  public Inmueble idInmueble(String idInmueble) {
    this.idInmueble = idInmueble;    
    return this;
  }

  /**
   * Identificador del inmueble
   * @return idInmueble
  **/
  @ApiModelProperty(value = "Identificador del inmueble")


  public String getIdInmueble() {
    return idInmueble;
  }

  public void setIdInmueble(String idInmueble) {
    this.idInmueble = idInmueble;
  }

  public Inmueble tipoInmueble(String tipoInmueble) {
    this.tipoInmueble = tipoInmueble;
    return this;
  }

  /**
   * Tipo de inmueble
   * @return tipoInmueble
  **/
  @ApiModelProperty(required = true, value = "Tipo de inmueble")
  @NotNull


  public String getTipoInmueble() {
    return tipoInmueble;
  }

  public void setTipoInmueble(String tipoInmueble) {
    this.tipoInmueble = tipoInmueble;
  }

  public Inmueble direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Dirección del inmueble
   * @return direccion
  **/
  @ApiModelProperty(required = true, value = "Dirección del inmueble")
  @NotNull


  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Inmueble ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }

  /**
   * Ciudad donde se encuentra ubicada el inmueble
   * @return ciudad
  **/
  @ApiModelProperty(required = true, value = "Ciudad donde se encuentra ubicada el inmueble")
  @NotNull


  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Inmueble estrato(Integer estrato) {
    this.estrato = estrato;
    return this;
  }

  /**
   * Estrato del inmueble
   * @return estrato
  **/
  @ApiModelProperty(required = true, value = "Estrato del inmueble")
  @NotNull


  public Integer getEstrato() {
    return estrato;
  }

  public void setEstrato(Integer estrato) {
    this.estrato = estrato;
  }

  public Inmueble valor(BigDecimal valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Precio sugerido del inmueble
   * @return valor
  **/
  @ApiModelProperty(required = true, value = "Precio sugerido del inmueble")
  @NotNull

  @Valid

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Inmueble detalles(String detalles) {
    this.detalles = detalles;
    return this;
  }

  /**
   * Descripción del inmueble
   * @return detalles
  **/
  @ApiModelProperty(required = true, value = "Descripción del inmueble")
  @NotNull


  public String getDetalles() {
    return detalles;
  }

  public void setDetalles(String detalles) {
    this.detalles = detalles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inmueble inmueble = (Inmueble) o;
    return Objects.equals(this.idInmueble, inmueble.idInmueble) &&
        Objects.equals(this.tipoInmueble, inmueble.tipoInmueble) &&
        Objects.equals(this.direccion, inmueble.direccion) &&
        Objects.equals(this.ciudad, inmueble.ciudad) &&
        Objects.equals(this.estrato, inmueble.estrato) &&
        Objects.equals(this.valor, inmueble.valor) &&
        Objects.equals(this.detalles, inmueble.detalles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idInmueble, tipoInmueble, direccion, ciudad, estrato, valor, detalles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inmueble {\n");
    
    sb.append("    idInmueble: ").append(toIndentedString(idInmueble)).append("\n");
    sb.append("    tipoInmueble: ").append(toIndentedString(tipoInmueble)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estrato: ").append(toIndentedString(estrato)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    detalles: ").append(toIndentedString(detalles)).append("\n");
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

