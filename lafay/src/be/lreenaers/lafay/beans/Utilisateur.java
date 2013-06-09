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
public class Utilisateur extends Bean{

	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private String passe;
	private String hash;
	public String getPasse() {
		return passe;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public void setPasse(String passe) {
		this.passe = passe;
	}
	@Reference
	private Niveau niveau;
	@Reference
	private List<Groupe> groups;
	

	public List<Groupe> getGroups() {
		return groups;
	}
	public void setGroups(List<Groupe> groups) {
		this.groups = groups;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String nomUtilisateur) {
		this.pseudo = nomUtilisateur;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
}
