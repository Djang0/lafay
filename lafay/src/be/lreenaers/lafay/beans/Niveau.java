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
public class Niveau extends Bean{
	
	private String nom;
	@Reference
	private List<Enchainable> series;
	
	public List<Enchainable> getSeries() {
		return series;
	}
	public void setSeries(List<Enchainable> series) {
		this.series = series;
	}
	public void setName(String nom){
		this.nom = nom;
	}
	public String getName(){
		return this.nom;
	}
	
}
