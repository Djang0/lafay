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
	private Exercice exercice;
	private Repos repos;
	private boolean enchainable;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchainable other = (Enchainable) obj;
		if (enchainable != other.enchainable)
			return false;
		if (exercice == null) {
			if (other.exercice != null)
				return false;
		} else if (!exercice.equals(other.exercice))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (ordre != other.ordre)
			return false;
		if (repos == null) {
			if (other.repos != null)
				return false;
		} else if (!repos.equals(other.repos))
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
		result = prime * result + (enchainable ? 1231 : 1237);
		result = prime * result
				+ ((exercice == null) ? 0 : exercice.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ordre;
		result = prime * result + ((repos == null) ? 0 : repos.hashCode());
		return result;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Repos getRepos() {
		return repos;
	}

	public void setRepos(Repos repos) {
		this.repos = repos;
	}

	public boolean isEnchainable() {
		if (this.exercice != null && this.repos != null){
			this.enchainable = true;
		}else{
			this.enchainable = false;
		}
		return this.enchainable;
	}

	public void setEnchainable(boolean enchainable) {
		this.enchainable = enchainable;
	}

}
