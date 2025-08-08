package com.gestionacademica.services;

import com.gestionacademica.entities.Profesor;
import com.gestionacademica.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor crear(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerPorId(String id) {
        return profesorRepository.findById(id);
    }

    public Profesor actualizar(String id, Profesor nuevo) {
        if (profesorRepository.existsById(id)) {
            nuevo.setIdProfesor(id);
            return profesorRepository.save(nuevo);
        }
        return null; // El controlador podrá devolver 404 en este caso
    }

    public boolean eliminar(String id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
 