package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Capitulos;

@Stateless
public class CapituloFacade extends AbstractFacade<Capitulos> {

	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public CapituloFacade() {
		super(Capitulos.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
