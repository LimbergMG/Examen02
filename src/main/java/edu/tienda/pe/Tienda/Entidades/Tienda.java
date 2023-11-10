package edu.tienda.pe.Tienda.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public
    Long id;
    public String nombre;
    public String ruc;
    public String web;
    public LocalDate fecha;
    public String direccion;

}
