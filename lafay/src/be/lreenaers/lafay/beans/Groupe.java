/**
 * 
 */
package be.lreenaers.lafay.beans;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

/**
 * @author media
 * 
 */
@Entity
public class Groupe extends Bean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	@Reference
	private List<Permission> permissions;

	public Groupe() {
		super();
		this.permissions = new ArrayList<Permission>();
		this.nom = new String();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((permissions == null) ? 0 : permissions.hashCode());
		return result;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
