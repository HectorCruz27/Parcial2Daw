package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;

@Stateless
public class DataServiceInscripcion {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;

    public void guardarInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }

    public List<Inscripcion> buscarInscripciones() {
        Query query = entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id ASC");
        return query.getResultList();
    }
}
