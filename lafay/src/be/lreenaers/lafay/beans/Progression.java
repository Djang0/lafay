package be.lreenaers.lafay.beans;

import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Progression extends Bean {
	private static final long serialVersionUID = 1L;
	@Reference
	private Niveau niveau;
	@Reference
	private List<Serie> series;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Progression other = (Progression) obj;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public List<Serie> getSeries() {
		return series;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
