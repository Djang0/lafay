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

	public String getNom() {
		return nom;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
