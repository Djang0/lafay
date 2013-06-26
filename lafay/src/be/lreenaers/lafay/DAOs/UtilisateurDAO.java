/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Utilisateur;

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
}
