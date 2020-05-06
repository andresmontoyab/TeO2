package com.teo2.prediosservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccionBucket;

    private Boolean principal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

    public Imagen(String nombre, String direccionBucket, Boolean principal) {
        this.nombre = nombre;
        this.direccionBucket = direccionBucket;
        this.principal = principal;
    }

    public Imagen() {
    }
}
