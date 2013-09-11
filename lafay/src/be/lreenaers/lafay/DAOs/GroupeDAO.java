/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class GroupeDAO extends DAO<Groupe> {

	public GroupeDAO(Class<Groupe> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Groupe entity) {
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		List<Utilisateur> usrs = ds.find(Utilisateur.class).field("groups").hasThisElement(entity).asList();
		Iterator<Utilisateur> it = usrs.iterator();
		List<Groupe> grps;
		Utilisateur usr;
		while(it.hasNext()){
			usr = it.next();
			grps = usr.getGroups();
			grps.remove(entity);
			usr.setGroups(grps);
			udao.save(usr);
		}
	}
	
}
