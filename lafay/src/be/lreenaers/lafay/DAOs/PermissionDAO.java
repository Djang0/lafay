/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class PermissionDAO extends DAO<Permission> {

	public PermissionDAO(Class<Permission> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Permission entity) {
		GroupeDAO gdao = DAOFactory.getGroupeDAO();
		List<Groupe> grps = ds.find(Groupe.class).field("permissions")
				.hasThisElement(entity).asList();
		Iterator<Groupe> it = grps.iterator();
		Groupe grp;
		List<Permission> perms;
		while (it.hasNext()) {
			grp = it.next();
			perms = grp.getPermissions();
			perms.remove(entity);
			grp.setPermissions(perms);
			gdao.save(grp);
		}
	}

}
