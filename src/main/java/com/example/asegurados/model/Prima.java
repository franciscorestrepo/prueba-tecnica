package com.example.asegurados.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Primas")

public class Prima {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "codigo_amparo", referencedColumnName = "codigo", nullable = false)
         private Amparo amparo;

        @Column(name = "edad_minima", nullable = false)
        private int edadMinima;

        @Column(name = "edad_maxima", nullable = false)
        private int edadMaxima;

        @Column(name = "porcentaje_prima", nullable = false)
        private double porcentajePrima;

        public int getEdadMinima() {
            return edadMinima;
        }

        public void setEdadMinima(int edadMinima) {
            this.edadMinima = edadMinima;
        }

        public int getEdadMaxima() {
            return edadMaxima;
        }

        public void setEdadMaxima(int edadMaxima) {
            this.edadMaxima = edadMaxima;
        }

        public double getPorcentajePrima() {
            return porcentajePrima;
        }

        public void setPorcentajePrima(double porcentajePrima) {
            this.porcentajePrima = porcentajePrima;
        }
}
