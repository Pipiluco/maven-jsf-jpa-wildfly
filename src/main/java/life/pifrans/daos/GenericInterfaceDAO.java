package life.pifrans.daos;

import java.util.List;

public interface GenericInterfaceDAO<T, ID> {

	public T save(T entity);

	public T find(Class<T> entityClass, ID id);

	public T update(T entity);

	public boolean remove(Class<T> entityClass, ID id);

	public List<T> findAll(Class<T> entityClass);
	
	public List<T> findByQuery(Class<T> entityClass);
}
