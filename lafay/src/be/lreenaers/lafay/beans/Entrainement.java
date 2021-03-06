/**
 * 
 */
package be.lreenaers.lafay.beans;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

/**
 * @author media
 * 
 */
@Entity
public class Entrainement extends Bean {

	private static final long serialVersionUID = 1L;

	private Date debutEntrainement;
	private Date finEntrainement;
	@Reference
	private Niveau niveau;
	@Reference
	private Utilisateur utilisateur;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrainement other = (Entrainement) obj;
		if (debutEntrainement == null) {
			if (other.debutEntrainement != null)
				return false;
		} else if (!debutEntrainement.equals(other.debutEntrainement))
			return false;
		if (finEntrainement == null) {
			if (other.finEntrainement != null)
				return false;
		} else if (!finEntrainement.equals(other.finEntrainement))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

	public Date getDebutEntrainement() {
		return debutEntrainement;
	}

	public Date getFinEntrainement() {
		return finEntrainement;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((debutEntrainement == null) ? 0 : debutEntrainement
						.hashCode());
		result = prime * result
				+ ((finEntrainement == null) ? 0 : finEntrainement.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result
				+ ((utilisateur == null) ? 0 : utilisateur.hashCode());
		return result;
	}

	public void setDebutEntrainement(Date debutEntrainement) {
		this.debutEntrainement = debutEntrainement;
	}

	public void setFinEntrainement(Date finEntrainement) {
		this.finEntrainement = finEntrainement;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
