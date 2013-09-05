package be.lreenaers.lafay.web.control;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.ExerciceDAO;
import be.lreenaers.lafay.DAOs.MouvementDAO;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Mouvement;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

@ManagedBean(name = "mouvementCtrl")
@SessionScoped
public class MouvementCtrl implements Controlable, RowEditable,
Filterable<Mouvement>  {
	
	private MouvementDAO dao;
	private ExerciceDAO edao;
	private ListDataModel<Mouvement> mouvements;
	private Mouvement mouvement;
	private Mouvement mouvementEdit;
	private List<Mouvement> filtered;
	public MouvementCtrl() {
		this.dao = DAOFactory.getMouvementDAO();
		this.mouvements = new ListDataModel<Mouvement>();
		this.mouvements.setWrappedData(this.dao.all());
		this.mouvement = new Mouvement();
		this.mouvementEdit = new Mouvement();

	}
	@Override
	public List<Mouvement> getFiltered() {
		return this.filtered;
	}

	@Override
	public void setFiltered(List<Mouvement> list) {
		this.filtered = list;
		
	}

	@Override
	public void onCancel(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdit(RowEditEvent event) {
		this.dao.save((Mouvement) event.getObject());
		
	}

	@Override
	public String create() {
		this.dao.save(this.mouvement);
		this.mouvement = new Mouvement();
		this.mouvements.setWrappedData(this.dao.all());
		return "goMouvList";
	}

	@Override
	public String delete() {
		this.edao = DAOFactory.getExerciceDAO();
		Mouvement m = (Mouvement) mouvements.getRowData();
		List<Exercice> exs = edao.all();
		Iterator<Exercice> it = exs.iterator();
		Exercice e;
		while (it.hasNext()) {
			e = it.next();
			e.remove(m);
			this.edao.save(e);
		}
		this.dao.delete(m);
		this.mouvements.setWrappedData(this.dao.all());
		return "goMouvList";
	}
	public String goCreate() {
		return "goCreateMv";
	}
	@Override
	public String update() {
		this.dao.save(this.mouvementEdit);
		this.mouvements.setWrappedData(this.dao.all());
		return "goMouvList";
	}
	public MouvementDAO getDao() {
		return dao;
	}
	public void setDao(MouvementDAO dao) {
		this.dao = dao;
	}
	public ExerciceDAO getEdao() {
		return edao;
	}
	public void setEdao(ExerciceDAO edao) {
		this.edao = edao;
	}
	public ListDataModel<Mouvement> getMouvements() {
		return mouvements;
	}
	public void setMouvements(ListDataModel<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}
	public Mouvement getMouvement() {
		return mouvement;
	}
	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}
	public Mouvement getMouvementEdit() {
		return mouvementEdit;
	}
	public void setMouvementEdit(Mouvement mouvementEdit) {
		this.mouvementEdit = mouvementEdit;
	}

}
