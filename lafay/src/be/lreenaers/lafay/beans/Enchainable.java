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
	private String nom;
	private int repetitionMinimum;
	private int repetitionEffective;
	private int dureeEnSeconde;
	private boolean pause;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchainable other = (Enchainable) obj;
		if (dureeEnSeconde != other.dureeEnSeconde)
			return false;
		if (exercice == null) {
			if (other.exercice != null)
				return false;
		} else if (!exercice.equals(other.exercice))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pause != other.pause)
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

	public String getNom() {
		return nom;
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
		result = prime * result + dureeEnSeconde;
		result = prime * result
				+ ((exercice == null) ? 0 : exercice.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + (pause ? 1231 : 1237);
		result = prime * result + repetitionEffective;
		result = prime * result + repetitionMinimum;
		return result;
	}

	public boolean isPause() {
		return pause;
	}

	public void setDureeEnSeconde(int dureeEnSeconde) {
		this.dureeEnSeconde = dureeEnSeconde;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void setRepetitionEffective(int repetitionEffective) {
		this.repetitionEffective = repetitionEffective;
	}

	public void setRepetitionMinimum(int repetitionMinimum) {
		this.repetitionMinimum = repetitionMinimum;
	}

}
