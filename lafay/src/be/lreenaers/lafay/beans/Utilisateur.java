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
	private String email;
	@Reference
	private List<Groupe> groups;
	private String hash;
	@Reference
	private Niveau niveau;
	private String nom;
	private String passe;
	private String prenom;
	private String pseudo;

	public Utilisateur() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (passe == null) {
			if (other.passe != null)
				return false;
		} else if (!passe.equals(other.passe))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((passe == null) ? 0 : passe.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		return result;
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
