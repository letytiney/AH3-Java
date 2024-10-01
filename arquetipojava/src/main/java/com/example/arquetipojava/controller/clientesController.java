package com.example.arquetipojava.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquetipojava.models.clientesModel;
import com.example.arquetipojava.service.clientesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/clientes")
public class clientesController {
    @Autowired
    private clientesService clientesService;

    @GetMapping("/listar")
    public Iterable<clientesModel> getClientes() {
        return this.clientesService.findAll();
    }
    @PostMapping("/guardar")
    public ResponseEntity<String> saveClientes(@RequestBody clientesModel entity) {
        try {
            this.clientesService.save(entity);
            return ResponseEntity.ok("Cliente guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }
    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<String> deleteClientes(@PathVariable int idCliente) {
        try {
            this.clientesService.deleteById(idCliente);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }
    @PutMapping("/actualizar/{idCliente}")
public ResponseEntity<String> updateClientes(@PathVariable int idCliente, @RequestBody clientesModel entity) {
    try {
      
        Optional<clientesModel> existingCliente = this.clientesService.findById(idCliente);
        
        if (existingCliente.isPresent()) {
            clientesModel clienteToUpdate = existingCliente.get();
            
            clienteToUpdate.setNombre(entity.getNombre());
            clienteToUpdate.setApellido(entity.getApellido());
            
         
            this.clientesService.save(clienteToUpdate);
            return ResponseEntity.ok().body("Cliente actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al actualizar el cliente");
    }
}



}
