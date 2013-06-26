/**
 * 
 */
package be.lreenaers.lafay.beans;

import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

/**
 * @author media
 * 
 */
@Entity
public class Utilisateur extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private String passe;
	private String hash;
	@Reference
	private Niveau niveau;
	@Reference
	private List<Groupe> groups;

	public String getEmail() {
		return email;
	}

	public List<Groupe> getGroups() {
		return groups;
	}

	public String getHash() {
		return hash;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public String getNom() {
		return nom;
	}

	public String getPasse() {
		return passe;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public void setGroups(List<Groupe> groups) {
		this.groups = groups;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPseudo(String nomUtilisateur) {
		this.pseudo = nomUtilisateur;
	}
}
