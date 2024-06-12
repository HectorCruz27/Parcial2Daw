package libcode.webapp.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

import java.util.Objects;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName = "inscripciones_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id")
    private Materia materia;

    @Column(name = "ciclo")
    private Integer ciclo;

    @Column(name = "año")
    private Integer año;

    @Column(name = "fecha_inscripcion")
    private LocalDate fecha_inscripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }


    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", ciclo=" + ciclo + ", año=" + año + ", fecha_inscripcion=" + fecha_inscripcion + '}';
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, Integer ciclo, Integer año, LocalDate fecha_inscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.año = año;
        this.ciclo = ciclo;
        this.fecha_inscripcion = fecha_inscripcion;
    }

     public Inscripcion() {

    }
}

