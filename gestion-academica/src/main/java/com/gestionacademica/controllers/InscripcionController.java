package com.gestionacademica.controllers;

import com.gestionacademica.entities.Inscripcion;
import com.gestionacademica.services.InscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    public ResponseEntity<Inscripcion> crear(@RequestBody Inscripcion ins) { return ResponseEntity.ok(inscripcionService.crear(ins)); }

    @GetMapping
    public List<Inscripcion> obtenerTodos() { return inscripcionService.obtenerTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> obtenerPorId(@PathVariable Long id) {
        return inscripcionService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizar(@PathVariable Long id, @RequestBody Inscripcion ins) {
        Inscripcion actualizado = inscripcionService.actualizar(id, ins);
        if (actualizado != null) return ResponseEntity.ok(actualizado);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}