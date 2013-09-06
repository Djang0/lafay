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
	private Niveau niveau;
	private int ordre;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchainable other = (Enchainable) obj;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (ordre != other.ordre)
			return false;
		return true;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public int getOrdre() {
		return ordre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ordre;
		return result;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

}
