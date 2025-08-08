package com.gestionacademica.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long idInscripcion;

    @Column(name = "carnet_estudiante", length = 15, nullable = false)
    private String carnetEstudiante;

    @Column(name = "id_curso", length = 10, nullable = false)
    private String idCurso;

    @Column(name = "semestre")
    private int semestre;

    @Column(name = "ciclo")
    private int ciclo;

    @Column(name = "nota_final", precision = 5, scale = 2)
    private BigDecimal notaFinal;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    public Inscripcion() {}

    // Getters y setters
    public Long getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(Long idInscripcion) { this.idInscripcion = idInscripcion; }

    public String getCarnetEstudiante() { return carnetEstudiante; }
    public void setCarnetEstudiante(String carnetEstudiante) { this.carnetEstudiante = carnetEstudiante; }

    public String getIdCurso() { return idCurso; }
    public void setIdCurso(String idCurso) { this.idCurso = idCurso; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }

    public BigDecimal getNotaFinal() { return notaFinal; }
    public void setNotaFinal(BigDecimal notaFinal) { this.notaFinal = notaFinal; }

    public LocalDate getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDate fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }
}
