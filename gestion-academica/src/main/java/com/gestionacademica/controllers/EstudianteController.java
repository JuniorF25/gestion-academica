package com.gestionacademica.controllers;

import com.gestionacademica.entities.Estudiante;
import com.gestionacademica.services.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante e) { return ResponseEntity.ok(estudianteService.crear(e)); }

    @GetMapping
    public List<Estudiante> obtenerTodos() { return estudianteService.obtenerTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable String id) {
        return estudianteService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable String id, @RequestBody Estudiante e) {
        Estudiante actualizado = estudianteService.actualizar(id, e);
        if (actualizado != null) return ResponseEntity.ok(actualizado);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}