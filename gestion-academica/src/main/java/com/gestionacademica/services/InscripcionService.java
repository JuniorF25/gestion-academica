package com.gestionacademica.services;

import com.gestionacademica.entities.Inscripcion;
import com.gestionacademica.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public Inscripcion crear(Inscripcion ins) { return inscripcionRepository.save(ins); }
    public List<Inscripcion> obtenerTodos() { return inscripcionRepository.findAll(); }
    public Optional<Inscripcion> obtenerPorId(Long id) { return inscripcionRepository.findById(id); }
    public Inscripcion actualizar(Long id, Inscripcion nuevo) {
        if (inscripcionRepository.existsById(id)) {
            nuevo.setIdInscripcion(id);
            return inscripcionRepository.save(nuevo);
        }
        return null;
    }
    public void eliminar(Long id) { inscripcionRepository.deleteById(id); }
}