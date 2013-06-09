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
	private String valeur;

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
