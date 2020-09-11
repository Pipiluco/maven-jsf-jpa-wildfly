package life.pifrans.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class GenericImplementationDAO<T, ID> implements GenericInterfaceDAO<T, ID> {

	@Inject
	@MySQLDatabase
	private EntityManager entityManager;

	@Override
	public T save(T entity) throws Exception {
		beginTransaction();
		T object = entityManager.merge(entity);
		commitTransaction();
		return object;
	}

	@Override
	public T find(Class<T> entityClass, ID id) throws Exception {
		beginTransaction();
		T object = entityManager.find(entityClass, id);
		commitTransaction();
		return object;
	}

	@Override
	public T update(T entity) throws Exception {
		beginTransaction();
		T object = entityManager.merge(entity);
		commitTransaction();
		return object;
	}

	@Override
	public boolean remove(Class<T> entityClass, ID id) throws Exception {
		beginTransaction();
		T object = entityManager.find(entityClass, id);
		entityManager.remove(object);
		commitTransaction();
		return true;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass) throws Exception {
		beginTransaction();
		Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t");
		List<T> objects = query.getResultList();
		commitTransaction();
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByQueryResultList(String queryString) throws Exception {
		beginTransaction();
		Query query = entityManager.createQuery(queryString);
		List<T> objects = query.getResultList();
		commitTransaction();

		System.out.println("Retorno: " + objects.size());
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByQueryResultSingle(String queryString) throws Exception {
		beginTransaction();
		T object = (T) entityManager.createQuery(queryString).getSingleResult();
		commitTransaction();
		return object;
	}

	private void beginTransaction() {
		try {
			entityManager.getTransaction().begin();
		} catch (IllegalStateException e) {
			rollBackTransaction();
		}
	}

	private void commitTransaction() {
		try {
			entityManager.getTransaction().commit();
		} catch (IllegalStateException | RollbackException e) {
			rollBackTransaction();
		}
	}

	private void rollBackTransaction() {
		try {
			entityManager.getTransaction().rollback();
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}
	}
}
