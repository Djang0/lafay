package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.lreenaers.lafay.beans.Repos;
import be.lreenaers.lafay.factories.DAOFactory;

@ManagedBean(name = "reposCtrl")
@SessionScoped
public class ReposCtrl extends Controler<Repos> {

	public ReposCtrl() {
		super(Repos.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	public List<Repos> getRepos() {
		return this.dao.all();
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getReposDAO();

	}

}
