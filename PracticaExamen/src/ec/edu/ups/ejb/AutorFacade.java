package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.modelo.Autor;

@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public AutorFacade() {
		super(Autor.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
	public Autor readAutor(String nombre) {
		Query query = em.createNamedQuery("getByAutor");
		query.setParameter("nombre", nombre);
		List result = query.getResultList();
		Autor respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Autor)result.get(0);
		}
		return respuesta;
	}

}
