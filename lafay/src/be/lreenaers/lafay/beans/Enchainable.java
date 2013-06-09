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
	@Reference
	private Exercice exercice;
	private int repetitionMinimum;
	private int repetitionEffective;
	private int dureeEnSeconde;
	private boolean compteur;
	
	public Exercice getExercice() {
		return exercice;
	}
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}
	public int getRepetitionMinimum() {
		return repetitionMinimum;
	}
	public void setRepetitionMinimum(int repetitionMinimum) {
		this.repetitionMinimum = repetitionMinimum;
	}
	public int getRepetitionEffective() {
		return repetitionEffective;
	}
	public void setRepetitionEffective(int repetitionEffective) {
		this.repetitionEffective = repetitionEffective;
	}
	public int getDureeEnSeconde() {
		return dureeEnSeconde;
	}
	public void setDureeEnSeconde(int dureeEnSeconde) {
		this.dureeEnSeconde = dureeEnSeconde;
	}
	public boolean isCompteur() {
		// <h:commandLink id="link" action="navigationPageX" rendered="#{sessionController.isTypeA}">
		return compteur;
	}
	public void setCompteur(boolean compteur) {
		this.compteur = compteur;
	}
	
	
	
}
