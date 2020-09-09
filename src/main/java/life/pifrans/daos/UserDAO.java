package life.pifrans.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import life.pifrans.models.User;

public class UserDAO {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("maven-jsf-jpa-wildfly");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public User find(String name, String password) {
		try {
			User user = (User) entityManager
					.createQuery("SELECT u FROM User u WHERE u.name =: name AND u.password =: password")
					.setParameter("name", name).setParameter("password", password).getSingleResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			return null;
		}
	}

	public boolean insert(User user) {
		try {
			entityManager.persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(User user) {
		try {
			entityManager.remove(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
