/**
 * 
 */
package be.lreenaers.lafay.beans;

import com.google.code.morphia.annotations.Entity;

/**
 * @author media
 * 
 */
@Entity
public class Permission extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valeur;

	public Permission() {
		super();
		this.valeur = new String();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}

	public String getValeur() {
		return valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
