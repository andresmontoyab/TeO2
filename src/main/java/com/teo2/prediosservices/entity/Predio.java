package com.teo2.prediosservices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Predio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePredio;

    private Boolean disponible;

    private String informationDelPredio;

    private String entidad;

    private String altura;

    private String propietario;

    private String cedulaCatastral;

    private String hectareas;

    private String ubicacion;

    private String departamento;

    private String municipio;

    private String Vereda;

    private String corregimiento;

    private String coberturas;

    private String bosques;

    private String cantidadCO2PorCobertura;

    private String planoCobertura;

    private String cantidadCO2Capturadas;

    private String tarjetaProfesional;

    private String valor;

    private String valorTeO2;
}
