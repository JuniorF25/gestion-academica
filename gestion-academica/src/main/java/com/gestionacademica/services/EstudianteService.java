package com.gestionacademica.services;

import com.gestionacademica.entities.Estudiante;
import com.gestionacademica.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crear(Estudiante e) { return estudianteRepository.save(e); }
    public List<Estudiante> obtenerTodos() { return estudianteRepository.findAll(); }
    public Optional<Estudiante> obtenerPorId(String id) { return estudianteRepository.findById(id); }
    public Estudiante actualizar(String id, Estudiante nuevo) {
        if (estudianteRepository.existsById(id)) {
            nuevo.setCarnet(id);
            return estudianteRepository.save(nuevo);
        }
        return null;
    }
    public void eliminar(String id) { estudianteRepository.deleteById(id); }
}
