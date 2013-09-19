package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.lreenaers.lafay.beans.Mouvement;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "mouvementCtrl")
@SessionScoped
public class MouvementCtrl extends Controler<Mouvement> {
	public MouvementCtrl() {
		super(Mouvement.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getMouvementDAO();

	}
	/**
	 * @return the mouvements
	 */
	public List<Mouvement> getMouvements() {
		return this.dao.all();
	}
}
