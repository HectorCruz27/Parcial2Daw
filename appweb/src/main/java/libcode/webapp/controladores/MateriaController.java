/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector y Mario
 */

package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataServiceMateria;

@Named
@RequestScoped
public class MateriaController {

    private List<Materia> materiaList = new ArrayList<>();

    private Materia materia = new Materia();
    
    @EJB
    DataServiceMateria servicio;

    @PostConstruct
    public void cargarMaterias() {
        materiaList = servicio.buscarMaterias();
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editarMateria(materia);
        } else {
            servicio.guardarMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }
    
    public void llenarFormEditar(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion()); 
        this.materia.setCodigo(materia.getCodigo());  
    }
    
    public void eliminarMateria(Materia materia) {
        servicio.eliminarMateria(materia);
        cargarMaterias();
    }

    // Getters and Setters
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
