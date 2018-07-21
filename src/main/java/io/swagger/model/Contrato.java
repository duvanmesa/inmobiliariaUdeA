package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contrato que estipula las pautas del alquiler de un inmueble a un cliente.
 */
@ApiModel(description = "Contrato que estipula las pautas del alquiler de un inmueble a un cliente.")
@Validated

public class Contrato extends ResourceSupport   {
  @JsonProperty("idContrato")
  private String idContrato = null;

  @JsonProperty("tipoContrato")
  private String tipoContrato = null;

  @JsonProperty("fechaInicio")
  private String fechaInicio = null;

  @JsonProperty("fechaFin")
  private String fechaFin = null;

  @JsonProperty("Estado")
  private String estado = null;

  @JsonProperty("clausula")
  private String clausula = null;

  @JsonProperty("idCiente")
  private String idCiente = null;

  @JsonProperty("idInmueble")
  private String idInmueble = null;

  public Contrato idContrato(String idContrato) {
    this.idContrato = idContrato;
    return this;
  }
  
  
  
  public Contrato() {
	  
  }
  

  public Contrato(String idContrato, String tipoContrato, String fechaInicio, String fechaFin, String estado,
		String clausula, String idCiente, String idInmueble) {
	super();
	this.idContrato = idContrato;
	this.tipoContrato = tipoContrato;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaFin;
	this.estado = estado;
	this.clausula = clausula;
	this.idCiente = idCiente;
	this.idInmueble = idInmueble;
}






/**
   * Identificador del contrato
   * @return idContrato
  **/
  @ApiModelProperty(value = "Identificador del contrato")


  public String getIdContrato() {
    return idContrato;
  }

  public void setIdContrato(String idContrato) {
    this.idContrato = idContrato;
  }

  public Contrato tipoContrato(String tipoContrato) {
    this.tipoContrato = tipoContrato;
    return this;
  }

  /**
   * Tipo de contrato a realizar
   * @return tipoContrato
  **/
  @ApiModelProperty(required = true, value = "Tipo de contrato a realizar")
  @NotNull


  public String getTipoContrato() {
    return tipoContrato;
  }

  public void setTipoContrato(String tipoContrato) {
    this.tipoContrato = tipoContrato;
  }

  public Contrato fechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
    return this;
  }

  /**
   * Fecha de inicio del contrato
   * @return fechaInicio
  **/
  @ApiModelProperty(value = "Fecha de inicio del contrato")

  @Valid

  public String getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Contrato fechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
    return this;
  }

  /**
   * Fecha de finalización del contrato
   * @return fechaFin
  **/
  @ApiModelProperty(value = "Fecha de finalización del contrato")

  @Valid

  public String getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Contrato estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Estado del contrato: vigente - no vigente
   * @return estado
  **/
  @ApiModelProperty(required = true, value = "Estado del contrato: vigente - no vigente")
  @NotNull


  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Contrato clausula(String clausula) {
    this.clausula = clausula;
    return this;
  }

  /**
   * Clausulas del contrato
   * @return clausula
  **/
  @ApiModelProperty(required = true, value = "Clausulas del contrato")
  @NotNull


  public String getClausula() {
    return clausula;
  }

  public void setClausula(String clausula) {
    this.clausula = clausula;
  }

  public Contrato idCiente(String idCiente) {
    this.idCiente = idCiente;
    return this;
  }

  /**
   * identificador del cliente
   * @return idCiente
  **/
  @ApiModelProperty(required = true, value = "identificador del cliente")
  @NotNull


  public String getIdCiente() {
    return idCiente;
  }

  public void setIdCiente(String idCiente) {
    this.idCiente = idCiente;
  }

  public Contrato idInmueble(String idInmueble) {
    this.idInmueble = idInmueble;
    return this;
  }

  /**
   * identificador del inmueble
   * @return idInmueble
  **/
  @ApiModelProperty(required = true, value = "identificador del inmueble")
  @NotNull


  public String getIdInmueble() {
    return idInmueble;
  }

  public void setIdInmueble(String idInmueble) {
    this.idInmueble = idInmueble;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contrato contrato = (Contrato) o;
    return Objects.equals(this.idContrato, contrato.idContrato) &&
        Objects.equals(this.tipoContrato, contrato.tipoContrato) &&
        Objects.equals(this.fechaInicio, contrato.fechaInicio) &&
        Objects.equals(this.fechaFin, contrato.fechaFin) &&
        Objects.equals(this.estado, contrato.estado) &&
        Objects.equals(this.clausula, contrato.clausula) &&
        Objects.equals(this.idCiente, contrato.idCiente) &&
        Objects.equals(this.idInmueble, contrato.idInmueble);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idContrato, tipoContrato, fechaInicio, fechaFin, estado, clausula, idCiente, idInmueble);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contrato {\n");
    
    sb.append("    idContrato: ").append(toIndentedString(idContrato)).append("\n");
    sb.append("    tipoContrato: ").append(toIndentedString(tipoContrato)).append("\n");
    sb.append("    fechaInicio: ").append(toIndentedString(fechaInicio)).append("\n");
    sb.append("    fechaFin: ").append(toIndentedString(fechaFin)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    clausula: ").append(toIndentedString(clausula)).append("\n");
    sb.append("    idCiente: ").append(toIndentedString(idCiente)).append("\n");
    sb.append("    idInmueble: ").append(toIndentedString(idInmueble)).append("\n");
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

