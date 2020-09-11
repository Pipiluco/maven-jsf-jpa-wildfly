package life.pifrans.daos;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ApplicationScoped
public class ManagerJPA implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_MYSQL = "MySQLDSPU";

	@Produces
	@RequestScoped
	@MySQLDatabase
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_MYSQL).createEntityManager();
	}

	public void close(@Disposes @MySQLDatabase EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
