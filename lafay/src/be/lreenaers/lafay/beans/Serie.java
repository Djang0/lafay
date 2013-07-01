package be.lreenaers.lafay.beans;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Serie extends Bean {
	private static final long serialVersionUID = 1L;
	@Reference
	private Enchainable enchainable;
	private int repetitionsCibles;
	private int repetitionsEffectives;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (enchainable == null) {
			if (other.enchainable != null)
				return false;
		} else if (!enchainable.equals(other.enchainable))
			return false;
		if (repetitionsCibles != other.repetitionsCibles)
			return false;
		if (repetitionsEffectives != other.repetitionsEffectives)
			return false;
		return true;
	}

	public Enchainable getEnchainable() {
		return enchainable;
	}

	public int getRepetitionsCibles() {
		return repetitionsCibles;
	}

	public int getRepetitionsEffectives() {
		return repetitionsEffectives;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((enchainable == null) ? 0 : enchainable.hashCode());
		result = prime * result + repetitionsCibles;
		result = prime * result + repetitionsEffectives;
		return result;
	}

	public void setEnchainable(Enchainable enchainable) {
		this.enchainable = enchainable;
	}

	public void setRepetitionsCibles(int repetitionsCibles) {
		this.repetitionsCibles = repetitionsCibles;
	}

	public void setRepetitionsEffectives(int repetitionsEffectives) {
		this.repetitionsEffectives = repetitionsEffectives;
	}
}
