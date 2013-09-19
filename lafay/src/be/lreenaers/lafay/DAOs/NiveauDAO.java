/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Niveau;

/**
 * @author media
 * 
 */
public class NiveauDAO extends DAO<Niveau> {

	public NiveauDAO(Class<Niveau> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Niveau entity) {
	}
}
