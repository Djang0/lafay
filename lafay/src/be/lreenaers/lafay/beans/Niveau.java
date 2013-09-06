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
	@Reference
	private List<Enchainable> enchainables;
	private String nom;

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
		if (enchainables == null) {
			if (other.enchainables != null)
				return false;
		} else if (!enchainables.equals(other.enchainables))
			return false;
		return true;
	}

	public String getNom() {
		return this.nom;
	}

	public List<Enchainable> getSeries() {
		return enchainables;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((enchainables == null) ? 0 : enchainables.hashCode());
		return result;
	}

	public void removeEnchainable(Enchainable ench) {
		this.enchainables.remove(ench);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setSeries(List<Enchainable> series) {
		this.enchainables = series;
	}
}
