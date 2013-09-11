package be.lreenaers.lafay.beans;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Repos extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duree;
	private String label;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repos other = (Repos) obj;
		if (duree != other.duree)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	public int getDuree() {
		return duree;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + duree;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
