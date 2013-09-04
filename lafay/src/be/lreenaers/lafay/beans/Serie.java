package be.lreenaers.lafay.beans;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Serie extends Bean {
	private static final long serialVersionUID = 1L;
	@Reference
	private Entrainement entrainement;
	@Reference
	private Mouvement mouvement;
	private Date debutSerie;
	private Date finSerie;
	private int repetitionsEffectives;
	private int ordre;
	public Entrainement getEntrainement() {
		return entrainement;
	}
	public void setEntrainement(Entrainement entrainement) {
		this.entrainement = entrainement;
	}
	public Mouvement getMouvement() {
		return mouvement;
	}
	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}
	public Date getDebutSerie() {
		return debutSerie;
	}
	public void setDebutSerie(Date debutSerie) {
		this.debutSerie = debutSerie;
	}
	public Date getFinSerie() {
		return finSerie;
	}
	public void setFinSerie(Date finSerie) {
		this.finSerie = finSerie;
	}
	public int getRepetitionsEffectives() {
		return repetitionsEffectives;
	}
	public void setRepetitionsEffectives(int repetitionsEffectives) {
		this.repetitionsEffectives = repetitionsEffectives;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((debutSerie == null) ? 0 : debutSerie.hashCode());
		result = prime * result
				+ ((entrainement == null) ? 0 : entrainement.hashCode());
		result = prime * result
				+ ((finSerie == null) ? 0 : finSerie.hashCode());
		result = prime * result
				+ ((mouvement == null) ? 0 : mouvement.hashCode());
		result = prime * result + ordre;
		result = prime * result + repetitionsEffectives;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (debutSerie == null) {
			if (other.debutSerie != null)
				return false;
		} else if (!debutSerie.equals(other.debutSerie))
			return false;
		if (entrainement == null) {
			if (other.entrainement != null)
				return false;
		} else if (!entrainement.equals(other.entrainement))
			return false;
		if (finSerie == null) {
			if (other.finSerie != null)
				return false;
		} else if (!finSerie.equals(other.finSerie))
			return false;
		if (mouvement == null) {
			if (other.mouvement != null)
				return false;
		} else if (!mouvement.equals(other.mouvement))
			return false;
		if (ordre != other.ordre)
			return false;
		if (repetitionsEffectives != other.repetitionsEffectives)
			return false;
		return true;
	}
}
