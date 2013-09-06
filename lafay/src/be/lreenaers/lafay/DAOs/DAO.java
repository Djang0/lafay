/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.List;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.factories.DBCFactory;

import com.google.code.morphia.Datastore;

/**
 * @author media
 * 
 */
public abstract class DAO<T> {
	protected Class<T> entityClass;
	protected Datastore ds;

	public DAO(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.ds = DBCFactory.getConnection();
	}

	public List<T> all() {
		return this.ds.find(this.entityClass).asList();
	}

	public void delete(T entity) {
		this.ds.delete((Class<T>) entity);
	}

	public T findById(ObjectId id) {
		return this.ds.get(this.entityClass, id);
	}

	public void save(T entity) {
		this.ds.save(entity);
	}
}
