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
	
	public Permission(){
		super();
		this.valeur = new String();
	}
	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public boolean equals(Object o){
		return ((Permission) o).getId().toString().equals(this.id.toString());
	}
}
