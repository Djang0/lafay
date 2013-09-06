package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.lreenaers.lafay.beans.Niveau;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "niveauCtrl")
@SessionScoped
public class NiveauCtrl extends Controler<Niveau> {
	public NiveauCtrl() {
		super(Niveau.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getNiveauDAO();

	}

}
