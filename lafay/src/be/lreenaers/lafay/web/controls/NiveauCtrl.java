package be.lreenaers.lafay.web.controls;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.ExerciceDAO;
import be.lreenaers.lafay.DAOs.NiveauDAO;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Niveau;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.Modifiable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

@ManagedBean(name = "niveauCtrl")
@SessionScoped
public class NiveauCtrl implements Controlable, RowEditable,
Filterable<Niveau>, Modifiable {
	
	private List<Niveau> filtered;
	private NiveauDAO dao;
	private NiveauDAO ndao;
	private Niveau niveau;
	private Niveau niveauEdit;
	private ListDataModel<Niveau> niveaux;
	
	@Override
	public String edit() {
		this.niveauEdit = (Niveau) this.niveaux.getRowData();
		return "goNivMod";
	}
	public String goCreate() {
		return "goCreateNiv";
	}
	@Override
	public List<Niveau> getFiltered() {
		return this.filtered;
	}

	@Override
	public void setFiltered(List<Niveau> list) {
		this.filtered = list;
	}

	@Override
	public void onCancel(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdit(RowEditEvent event) {
		this.dao.save((Niveau) event.getObject());
		
	}

	@Override
	public String create() {
		this.dao.save(this.niveau);
		this.niveau = new Niveau();
		this.niveaux.setWrappedData(this.dao.all());
		return "goNivLst";
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

	public NiveauDAO getDao() {
		return dao;
	}

	public void setDao(NiveauDAO dao) {
		this.dao = dao;
	}

	public NiveauDAO getNdao() {
		return ndao;
	}

	public void setNdao(NiveauDAO ndao) {
		this.ndao = ndao;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Niveau getNiveauEdit() {
		return niveauEdit;
	}

	public void setNiveauEdit(Niveau niveauEdit) {
		this.niveauEdit = niveauEdit;
	}

	public ListDataModel<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(ListDataModel<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

}
