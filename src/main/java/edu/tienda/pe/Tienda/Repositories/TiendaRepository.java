package edu.tienda.pe.Tienda.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tienda.pe.Tienda.Entidades.Tienda;

public interface TiendaRepository  extends JpaRepository <Tienda,Long>{
        @Query("select ma from Tienda as ma where nombre like CONCAT('%',:nombre,'%')")
    List<Tienda> buscarTiendaPorNombre(String nombre);

}
