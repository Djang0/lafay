package be.lreenaers.lafay.web.interfaces;

import java.util.List;

public interface Filterable<p> {
	public List<p> getFiltered();

	public void setFiltered(List<p> list);
}
