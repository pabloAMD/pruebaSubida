package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.modelo.Libro;

@Stateless

public class LibroFacade extends AbstractFacade<Libro> {
	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	

	public LibroFacade() {
		super(Libro.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Libro readLibro(String nombre) {
		Query query = em.createNamedQuery("getByLibro");
		query.setParameter("nombre", nombre);
		List result = query.getResultList();
		Libro respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Libro)result.get(0);
		}
		return respuesta;
	}
	

}
