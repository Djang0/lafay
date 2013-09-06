package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "groupeCtrl")
@SessionScoped
public class GroupeCtrl extends Controler<Groupe> {
	public GroupeCtrl() {
		super(Groupe.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getGroupeDAO();

	}
}
