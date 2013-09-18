package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Mouvement;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "exerciceCtrl")
@SessionScoped
public class ExerciceCtrl extends Controler<Exercice> {
	private List<Mouvement> mouvements;
	public ExerciceCtrl() {
		super(Exercice.class);
		this.entityClassList.setWrappedData(this.dao.all());
		this.mouvements = DAOFactory.getMouvementDAO().all();
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getExerciceDAO();

	}

	/**
	 * @return the mouvements
	 */
	public List<Mouvement> getMouvements() {
		return mouvements;
	}

	/**
	 * @param mouvements the mouvements to set
	 */
	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}
}
