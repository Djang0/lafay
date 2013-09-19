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
	private String description;
	private boolean enchainable;
	@Reference
	private Exercice exercice;
	@Reference
	private Repos repos;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Enchainable)) {
			return false;
		}
		Enchainable other = (Enchainable) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (enchainable != other.enchainable) {
			return false;
		}
		if (exercice == null) {
			if (other.exercice != null) {
				return false;
			}
		} else if (!exercice.equals(other.exercice)) {
			return false;
		}
		if (repos == null) {
			if (other.repos != null) {
				return false;
			}
		} else if (!repos.equals(other.repos)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public Repos getRepos() {
		return repos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enchainable ? 1231 : 1237);
		result = prime * result
				+ ((exercice == null) ? 0 : exercice.hashCode());
		result = prime * result + ((repos == null) ? 0 : repos.hashCode());
		return result;
	}

	public boolean isEnchainable() {
		if (this.exercice != null && this.repos != null) {
			this.enchainable = true;
		} else {
			this.enchainable = false;
		}
		return this.enchainable;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setEnchainable(boolean enchainable) {
		this.enchainable = enchainable;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public void setRepos(Repos repos) {
		this.repos = repos;
	}

}
