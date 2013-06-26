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
