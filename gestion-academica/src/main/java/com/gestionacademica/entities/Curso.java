package com.gestionacademica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "id_curso", length = 10)
    private String idCurso;

    @Column(name = "nombre_materia", nullable = false, length = 100)
    private String nombreMateria;

    @Column(name = "creditos")
    private int creditos;

    @Column(name = "semestre")
    private int semestre;

    @Column(name = "ciclo")
    private int ciclo;

    // FK simple para evitar complejidad en JSON
    @Column(name = "id_profesor", length = 10)
    private String idProfesor;

    @Column(name = "id_prerrequisito", length = 10)
    private String idPrerrequisito; // nullable

    public Curso() {}

    // Getters y setters
    public String getIdCurso() { return idCurso; }
    public void setIdCurso(String idCurso) { this.idCurso = idCurso; }

    public String getNombreMateria() { return nombreMateria; }
    public void setNombreMateria(String nombreMateria) { this.nombreMateria = nombreMateria; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }

    public String getIdProfesor() { return idProfesor; }
    public void setIdProfesor(String idProfesor) { this.idProfesor = idProfesor; }

    public String getIdPrerrequisito() { return idPrerrequisito; }
    public void setIdPrerrequisito(String idPrerrequisito) { this.idPrerrequisito = idPrerrequisito; }
}
