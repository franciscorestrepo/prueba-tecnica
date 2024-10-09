package com.example.asegurados.model;

import jakarta.persistence.*;
import lombok.Data;



import java.util.Date;

@Data
@Entity
@Table(name = "Asegurados")

public class Asegurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_identificacion", nullable = false)
    private Integer tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false, unique = true)
    private String nroIdentificacion;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "sexo", nullable = false)
    private int sexo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
