/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Entrainement;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO(Class<Utilisateur> entityClass) {
		super(entityClass);
	}

	public Utilisateur findByEmail(String email) {
		return this.ds.find(this.entityClass).field("email").equal(email).get();
	}

	public Utilisateur findByPseudo(String pseudo) {
		return this.ds.find(this.entityClass).field("pseudo").equal(pseudo)
				.get();
	}

	@Override
	public void deleteRelatedAncestors(Utilisateur entity) {
		EntrainementDAO edao = DAOFactory.getEntrainementDAO();
		edao.delete(ds.find(Entrainement.class).field("utilisateur").hasThisElement(entity).asList());	
	}
}
