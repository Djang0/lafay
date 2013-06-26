/**
 * 
 */
package be.lreenaers.lafay.beans;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

/**
 * @author media
 * 
 */
@Entity
public class Enchainable extends Bean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Reference
	private Exercice exercice;
	private int repetitionMinimum;
	private int repetitionEffective;
	private int dureeEnSeconde;
	private boolean compteur;

	public int getDureeEnSeconde() {
		return dureeEnSeconde;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public int getRepetitionEffective() {
		return repetitionEffective;
	}

	public int getRepetitionMinimum() {
		return repetitionMinimum;
	}

	public boolean isCompteur() {
		// <h:commandLink id="link" action="navigationPageX"
		// rendered="#{sessionController.isTypeA}">
		return compteur;
	}

	public void setCompteur(boolean compteur) {
		this.compteur = compteur;
	}

	public void setDureeEnSeconde(int dureeEnSeconde) {
		this.dureeEnSeconde = dureeEnSeconde;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public void setRepetitionEffective(int repetitionEffective) {
		this.repetitionEffective = repetitionEffective;
	}

	public void setRepetitionMinimum(int repetitionMinimum) {
		this.repetitionMinimum = repetitionMinimum;
	}

}
