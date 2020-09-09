package life.pifrans.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerJPA {
	private static final String PERSISTENCE_UNIT_MYSQL = "maven-jsf-jpa-wildfly";
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_MYSQL);
		}
		return entityManagerFactory.createEntityManager();
	}

	public static void close() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}
