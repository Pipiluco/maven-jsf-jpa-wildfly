package life.pifrans.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericImplementationDAO<T, ID> implements GenericInterfaceDAO<T, ID> {

	/*
	 * ManagerJPA.close(); }
	 */

	@Override
	public T save(T entity) {
		EntityManager em = ManagerJPA.getEntityManager();
		em.getTransaction().begin();
		T object = em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return object;
	}

	@Override
	public T find(Class<T> entityClass, ID id) {
		EntityManager em = ManagerJPA.getEntityManager();
		em.getTransaction().begin();
		T object = em.find(entityClass, id);
		em.getTransaction().commit();
		em.close();
		return object;
	}

	@Override
	public T update(T entity) {
		EntityManager em = ManagerJPA.getEntityManager();
		em.getTransaction().begin();
		T object = em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return object;
	}

	@Override
	public boolean remove(Class<T> entityClass, ID id) {
		try {
			EntityManager em = ManagerJPA.getEntityManager();
			em.getTransaction().begin();
			T object = em.find(entityClass, id);
			em.remove(object);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.toString());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass) {
		EntityManager em = ManagerJPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t");
		List<T> objects = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return objects;
	}
	
	@Override
	public List<T> findByQuery(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
