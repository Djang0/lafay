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
public class Entrainement extends Bean{
	
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
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Date getDebutEntrainement() {
		return debutEntrainement;
	}
	public void setDebutEntrainement(Date debutEntrainement) {
		this.debutEntrainement = debutEntrainement;
	}
	public Date getFinEntrainement() {
		return finEntrainement;
	}
	public void setFinEntrainement(Date finEntrainement) {
		this.finEntrainement = finEntrainement;
	}
	public Niveau getNiveauEntrainement() {
		return niveauEntrainement;
	}
	public void setNiveauEntrainement(Niveau niveauEntrainement) {
		this.niveauEntrainement = niveauEntrainement;
	}
	
}
