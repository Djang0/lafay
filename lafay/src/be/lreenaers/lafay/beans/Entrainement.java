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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date debutEntrainement;
	private Date finEntrainement;
	@Reference
	private Niveau niveauEntrainement;
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
		if (niveauEntrainement == null) {
			if (other.niveauEntrainement != null)
				return false;
		} else if (!niveauEntrainement.equals(other.niveauEntrainement))
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

	public Niveau getNiveauEntrainement() {
		return niveauEntrainement;
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
		result = prime
				* result
				+ ((niveauEntrainement == null) ? 0 : niveauEntrainement
						.hashCode());
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

	public void setNiveauEntrainement(Niveau niveauEntrainement) {
		this.niveauEntrainement = niveauEntrainement;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
