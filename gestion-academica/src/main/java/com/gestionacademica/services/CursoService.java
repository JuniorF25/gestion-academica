package com.gestionacademica.services;

import com.gestionacademica.entities.Curso;
import com.gestionacademica.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso crear(Curso curso) { return cursoRepository.save(curso); }

    public List<Curso> obtenerTodos() { return cursoRepository.findAll(); }

    public Optional<Curso> obtenerPorId(String id) { return cursoRepository.findById(id); }

    public Curso actualizar(String id, Curso nuevo) {
        if (cursoRepository.existsById(id)) {
            nuevo.setIdCurso(id);
            return cursoRepository.save(nuevo);
        }
        return null;
    }

    public void eliminar(String id) { cursoRepository.deleteById(id); }
}     


//    

