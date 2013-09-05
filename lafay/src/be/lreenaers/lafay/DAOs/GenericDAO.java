package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Permission;

public class GenericDAO extends DAO<Permission> {
	public GenericDAO(Class<Permission> entityClass) {
		super(entityClass);
	}
}
