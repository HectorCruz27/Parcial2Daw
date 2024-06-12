/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.negocio;

/**
 *
 * @author Hector Contreras
 */
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Materia;

@Stateless
public class DataServiceMateria {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;

    public List<Materia> buscarMaterias() {
        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id ASC");
        return query.getResultList();
    }

    @Transactional
    public void guardarMateria(Materia materia) {
        entityManager.persist(materia);
    }

    @Transactional
    public void editarMateria(Materia materia) {
        entityManager.merge(materia);
    }

    @Transactional
    public void eliminarMateria(Materia materia) {
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
}

