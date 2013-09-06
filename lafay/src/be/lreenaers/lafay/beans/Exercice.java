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
public class Exercice extends Enchainable {
	private static final long serialVersionUID = 1L;
	private int dureePause;
	@Reference
	private Mouvement mouvement;
	private int nombreDeSerie;
	private int repetitionMinimum;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercice other = (Exercice) obj;
		if (dureePause != other.dureePause)
			return false;
		if (mouvement == null) {
			if (other.mouvement != null)
				return false;
		} else if (!mouvement.equals(other.mouvement))
			return false;
		if (nombreDeSerie != other.nombreDeSerie)
			return false;
		if (repetitionMinimum != other.repetitionMinimum)
			return false;
		return true;
	}

	public int getDureePause() {
		return dureePause;
	}

	public Mouvement getMouvement() {
		return mouvement;
	}

	public int getNombreDeSerie() {
		return nombreDeSerie;
	}

	public int getRepetitionMinimum() {
		return repetitionMinimum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dureePause;
		result = prime * result
				+ ((mouvement == null) ? 0 : mouvement.hashCode());
		result = prime * result + nombreDeSerie;
		result = prime * result + repetitionMinimum;
		return result;
	}

	public void remove(Mouvement tmp) {
		if (this.mouvement.equals(tmp)) {
			this.mouvement = null;
		}
	}

	public void setDureePause(int dureePause) {
		this.dureePause = dureePause;
	}

	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}

	public void setNombreDeSerie(int nombreDeSerie) {
		this.nombreDeSerie = nombreDeSerie;
	}

	public void setRepetitionMinimum(int repetitionMinimum) {
		this.repetitionMinimum = repetitionMinimum;
	}
}
