package com.example.asegurados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LiquidacionDTO {

    @JsonProperty("tipo_identificacion")
    private int tipoIdentificacion;

    @JsonProperty("numero_identificacion")
    private String nroIdentificacion;

    @JsonProperty("valor_asegurado")
    private double valorAsegurado;
    private List<AmparoLiquidacion> liquidacion;
    private double valorTotal;

    public static class AmparoLiquidacion {
        private int codigoAmparo;
        private String nombreAmparo;
        private double valorPrima;
        public AmparoLiquidacion() {
        }

        public int getCodigoAmparo() {
            return codigoAmparo;
        }

        public void setCodigoAmparo(int codigoAmparo) {
            this.codigoAmparo = codigoAmparo;
        }

        public String getNombreAmparo() {
            return nombreAmparo;
        }

        public void setNombreAmparo(String nombreAmparo) {
            this.nombreAmparo = nombreAmparo;
        }

        public double getValorPrima() {
            return valorPrima;
        }

        public void setValorPrima(double valorPrima) {
            this.valorPrima = valorPrima;
        }
    }
    public LiquidacionDTO() {

    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public double getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(double valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }

    public List<AmparoLiquidacion> getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(List<AmparoLiquidacion> liquidacion) {
        this.liquidacion = liquidacion;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
