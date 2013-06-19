package be.lreenaers.lafay.web.interfaces;

import org.primefaces.event.RowEditEvent;

public interface RowEditable {
	public void onEdit(RowEditEvent event);
	public void onCancel(RowEditEvent event);
}
