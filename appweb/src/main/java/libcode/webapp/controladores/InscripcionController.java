package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.time.LocalDate;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataServiceInscripcion;

import java.util.List;
import libcode.webapp.negocio.DataService;
import libcode.webapp.negocio.DataServiceMateria;

@Named
@RequestScoped
public class InscripcionController {

    private int alumno_id;
    private int materia_id;
    private int ciclo;
    private int año;
    private LocalDate fecha_inscripcion;
    private List<Alumno> listaEstudiantes;
    private List<Materia> listaMaterias;
    private List<Inscripcion> listaInscripciones;

    @EJB
    DataService servicioAlumno;

    @EJB
    DataServiceMateria servicioMateria;

    @EJB
    DataServiceInscripcion servicioInscripcion;

    @PostConstruct
    public void init() {
        listaEstudiantes = servicioAlumno.getAlumnos();
        listaMaterias = servicioMateria.buscarMaterias();
        listaInscripciones = servicioInscripcion.buscarInscripciones();
    }

    public void guardarInscripcion() {
        Alumno alumno = new Alumno();
        alumno.setId(alumno_id);

        Materia materia = new Materia();
        materia.setId(materia_id);

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);
        inscripcion.setAño(año);
        inscripcion.setCiclo(ciclo);
        LocalDate fechaActual = LocalDate.now();
        inscripcion.setFecha_inscripcion(fechaActual);

        servicioInscripcion.guardarInscripcion(inscripcion);
        servicioInscripcion.buscarInscripciones();
    }

    // Getters and Setters
    public int getalumno_id() {
        return alumno_id;
    }

    public void setalumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getmateria_id() {
        return materia_id;
    }

    public void setmateria_id(int materia_id) {
        this.materia_id = materia_id;
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

    

    public List<Alumno> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Alumno> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<Inscripcion> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }

}

