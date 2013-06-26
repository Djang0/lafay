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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchainable other = (Enchainable) obj;
		if (compteur != other.compteur)
			return false;
		if (dureeEnSeconde != other.dureeEnSeconde)
			return false;
		if (exercice == null) {
			if (other.exercice != null)
				return false;
		} else if (!exercice.equals(other.exercice))
			return false;
		if (repetitionEffective != other.repetitionEffective)
			return false;
		if (repetitionMinimum != other.repetitionMinimum)
			return false;
		return true;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (compteur ? 1231 : 1237);
		result = prime * result + dureeEnSeconde;
		result = prime * result
				+ ((exercice == null) ? 0 : exercice.hashCode());
		result = prime * result + repetitionEffective;
		result = prime * result + repetitionMinimum;
		return result;
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
