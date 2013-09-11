package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Cible;

public class CibleDAO extends DAO<Cible> {

	public CibleDAO(Class<Cible> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Cible entity) {}

}
