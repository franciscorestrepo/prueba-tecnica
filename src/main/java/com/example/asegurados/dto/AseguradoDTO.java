package com.example.asegurados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AseguradoDTO {

    @JsonProperty("tipo_identificacion")
    private Integer tipoIdentificacion;

    @JsonProperty("numero_identificacion")
    private String nroIdentificacion;

    @JsonProperty("valor_asegurado")
    private Double valorAsegurado;

    public AseguradoDTO() {

    }


    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public Double getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(Double valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }

}
