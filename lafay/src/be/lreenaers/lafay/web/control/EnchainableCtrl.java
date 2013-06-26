/**
 * 
 */
package be.lreenaers.lafay.web.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

/**
 * @author media
 * 
 */
@ManagedBean(name = "enchainableCtrl")
@SessionScoped
public class EnchainableCtrl implements Controlable, RowEditable,
		Filterable<Groupe> {

	@Override
	public List<Groupe> getFiltered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFiltered(List<Groupe> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCancel(RowEditEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEdit(RowEditEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
