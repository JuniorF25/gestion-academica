package com.gestionacademica.controllers;

import com.gestionacademica.entities.Profesor;
import com.gestionacademica.services.ProfesorService; // asegúrate que el paquete sea "services"
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.crear(profesor));
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodos() {
        return ResponseEntity.ok(profesorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable String id) {
        return profesorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable String id, @RequestBody Profesor profesor) {
        Profesor actualizado = profesorService.actualizar(id, profesor);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable String id) {
        return profesorService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
