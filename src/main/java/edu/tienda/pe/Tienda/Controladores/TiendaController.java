package edu.tienda.pe.Tienda.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.tienda.pe.Tienda.TiendaRequest;
import edu.tienda.pe.Tienda.Entidades.Tienda;
import edu.tienda.pe.Tienda.Repositories.TiendaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController

@AllArgsConstructor

@RequestMapping("tienda")
public class TiendaController {
    
    TiendaRepository tiendaRepository;

        @GetMapping
    public List<Tienda> findAll(String nombre){
        if(nombre != null){

            return tiendaRepository.buscarTiendaPorNombre(nombre);
        }
        return tiendaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Tienda> findById(@PathVariable Long id){
        
        return ResponseEntity.of(tiendaRepository.findById(id));
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long register(@RequestBody @Valid TiendaRequest tiendaRequest){
        Tienda tienda = new Tienda();
       tienda.nombre = tiendaRequest.nombre;
       tienda.ruc = tiendaRequest.ruc;
       tienda.web = tiendaRequest.web;
       tienda.fecha = tiendaRequest.fecha;      
       tienda.direccion = tiendaRequest.direccion;

    


       Tienda tiendaGuardada =  tiendaRepository.save(tienda);  
       return tiendaGuardada.id;
    }

    @DeleteMapping("{id}")
    public  void deleteById(@PathVariable Long id){

        tiendaRepository.deleteById(id);;
    }

        @PutMapping("{id}")
    public ResponseEntity<Tienda> update(@PathVariable Long id,@RequestBody @Valid TiendaRequest tiendaRequest){

       Optional<Tienda> tiendaOptional= tiendaRepository.findById(id);
       if(tiendaOptional.isPresent()){
        Tienda tienda = tiendaOptional.get();
       tienda.nombre = tiendaRequest.nombre;
       tienda.ruc = tiendaRequest.ruc;
       tienda.web = tiendaRequest.web;
       tienda.fecha = tiendaRequest.fecha;      
       tienda.direccion = tiendaRequest.direccion;
        tiendaRepository.save(tienda);

        return ResponseEntity.ok(tienda);
       }
       return ResponseEntity.notFound().build();
    }

    
    @PatchMapping("{id}")
    public ResponseEntity<Tienda> updatePartial(@PathVariable Long id,@RequestBody  TiendaRequest tiendaRequest){

            return tiendaRepository.findById(id).map(tienda ->{
                if(tiendaRequest.nombre !=null){
                    tienda.nombre = tiendaRequest.nombre;
                }

              if(tiendaRequest.ruc !=null){
                    tienda.ruc = tiendaRequest.ruc;
                }

               if(tiendaRequest.web !=null){
                    tienda.web = tiendaRequest.web;
                }

              if(tiendaRequest.fecha !=null){
                    tienda.fecha = tiendaRequest.fecha;
                }

               if(tiendaRequest.direccion !=null){
                    tienda.direccion = tiendaRequest.direccion;
                }

                tiendaRepository.save(tienda);


                return ResponseEntity.ok(tienda);
            }).orElseGet(()-> ResponseEntity.notFound().build());
       
    }
}
