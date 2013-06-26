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
public class Exercice extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String description;

	public String getDescription() {
		return description;
	}

	public String getNom() {
		return nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
