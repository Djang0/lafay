/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;


import org.bson.types.ObjectId;

import be.lreenaers.lafay.factories.DBCFactory;
import be.lreenaers.lafay.interfaces.Deletable;

import com.google.code.morphia.Datastore;

/**
 * @author media
 * 
 */
public abstract class DAO<T> implements Deletable<T>{
	protected Datastore ds;
	protected Class<T> entityClass;

	public DAO(Class<T> entityClassx) {
		entityClass = entityClassx;
		ds = DBCFactory.getConnection();
	}

	public List<T> all() {
		return ds.find(entityClass).asList();
	}

	public void delete(T entity) {
		deleteRelatedAncestors(entity);
		ds.delete(entity);
	}
	public void delete(List<T> lst){
		Iterator<T> it =lst.iterator();
		while(it.hasNext()){
			delete(it.next());
		}
	}

	public T findById(ObjectId id) {
		return ds.get(entityClass, id);
	}

	public void save(T entity) {
		ds.save(entity);
	}
	public T findOne(String fieldname,String value){
		return ds.find(entityClass).field(fieldname).equal(value).get();
	}
	public List<T> findAll(String fieldname,String value){
		return ds.find(entityClass).field(fieldname).equal(value).asList();
	}
	
	/*public String getRelatedAncestor(T elemObj,Class ancestorClass, String field){
		//TODO : continue not WORKING
		ds.find(ancestorClass).field(field).hasThisElement(elemObj);
		return g.getNom();
	}*/
}
