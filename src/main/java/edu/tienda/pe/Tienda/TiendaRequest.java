package edu.tienda.pe.Tienda;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class TiendaRequest {
    @NotBlank
        public String nombre;
        @NotBlank
    public String ruc;
    @NotBlank
    public String web;
   
    public LocalDate fecha;
    @NotBlank
    public String direccion;
}
