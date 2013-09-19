package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "exerciceCtrl")
@SessionScoped
public class ExerciceCtrl extends Controler<Exercice> {
	public ExerciceCtrl() {
		super(Exercice.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getExerciceDAO();

	}
}
