package life.pifrans.daos;

import java.util.List;

public interface GenericInterfaceDAO<T, ID> {

	public T save(T entity) throws Exception;

	public T find(Class<T> entityClass, ID id) throws Exception;

	public T update(T entity) throws Exception;

	public boolean remove(Class<T> entityClass, ID id) throws Exception;

	public List<T> findAll(Class<T> entityClass) throws Exception;

	public T findByQueryResultSingle(String queryString) throws Exception;
	
	public List<T> findByQueryResultList(String queryString) throws Exception;
}
