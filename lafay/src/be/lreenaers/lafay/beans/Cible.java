package be.lreenaers.lafay.beans;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Cible extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Reference
	private Entrainement entrainement;
	@Reference
	private Mouvement mouvement;
	private int repetitionsCible;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cible other = (Cible) obj;
		if (entrainement == null) {
			if (other.entrainement != null)
				return false;
		} else if (!entrainement.equals(other.entrainement))
			return false;
		if (mouvement == null) {
			if (other.mouvement != null)
				return false;
		} else if (!mouvement.equals(other.mouvement))
			return false;
		if (repetitionsCible != other.repetitionsCible)
			return false;
		return true;
	}

	public Entrainement getEntrainement() {
		return entrainement;
	}

	public Mouvement getMouvement() {
		return mouvement;
	}

	public int getRepetitionsCible() {
		return repetitionsCible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((entrainement == null) ? 0 : entrainement.hashCode());
		result = prime * result
				+ ((mouvement == null) ? 0 : mouvement.hashCode());
		result = prime * result + repetitionsCible;
		return result;
	}

	public void setEntrainement(Entrainement entrainement) {
		this.entrainement = entrainement;
	}

	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}

	public void setRepetitionsCible(int repetitionsCible) {
		this.repetitionsCible = repetitionsCible;
	}

}
