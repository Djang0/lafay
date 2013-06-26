/**
 * 
 */
package be.lreenaers.lafay.beans;

import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

/**
 * @author media
 * 
 */
@Entity
public class Niveau extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	@Reference
	private List<Enchainable> series;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Niveau other = (Niveau) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}

	public String getName() {
		return this.nom;
	}

	public List<Enchainable> getSeries() {
		return series;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}

	public void setName(String nom) {
		this.nom = nom;
	}

	public void setSeries(List<Enchainable> series) {
		this.series = series;
	}
}
