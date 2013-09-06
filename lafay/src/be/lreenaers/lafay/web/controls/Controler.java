package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.DAO;
import be.lreenaers.lafay.web.directions.CreateDirection;
import be.lreenaers.lafay.web.directions.Direction;
import be.lreenaers.lafay.web.directions.ListDirection;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

public abstract class Controler<C> implements Controlable, RowEditable,
		Filterable<C> {
	protected Class<C> cls;
	protected DAO<C> dao;
	protected C entityClass;
	protected C entityClassDelete;
	protected C entityClassEdit;
	protected ListDataModel<C> entityClassList;
	protected List<C> filtered;

	public Controler(Class<C> ccls) {
		cls = ccls;
		selectDAO();
		entityClassList = new ListDataModel<C>();
		try {
			entityClassEdit = cls.newInstance();
			entityClass = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public String add() {
		return getNavigationString(new CreateDirection());
	}

	@Override
	public String create() {
		dao.save(entityClass);
		try {
			entityClass = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		entityClassList.setWrappedData(dao.all());
		return getNavigationString(new ListDirection());
	}

	@Override
	public String delete() {
		entityClassDelete = (C) entityClassList.getRowData();
		dao.delete(entityClassDelete);
		entityClassList.setWrappedData(dao.all());
		return getNavigationString(new ListDirection());
	}

	public Class<C> getCls() {
		return cls;
	}

	public DAO<C> getDao() {
		return dao;
	}

	public C getEntityClass() {
		return entityClass;
	}

	public C getEntityClassDelete() {
		return entityClassDelete;
	}

	public C getEntityClassEdit() {
		return entityClassEdit;
	}

	public ListDataModel<C> getEntityClassList() {
		return entityClassList;
	}

	@Override
	public List<C> getFiltered() {
		return filtered;
	}

	public String getNavigationString(Direction action) {

		String act = action.getAction();
		if (act == null) {
			act = "List";
		}
		String ctrl = cls.getSimpleName();
		if (act.equals("Connect") || act.equals("Forbide")
				|| act.equals("Board")) {
			ctrl = "Utilisateur";
		}
		String navigationString = ctrl + act;
		return navigationString;
	}

	@Override
	public void onCancel(RowEditEvent event) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onEdit(RowEditEvent event) {
		dao.save((C) event.getObject());
	}

	public void setCls(Class<C> cls) {
		this.cls = cls;
	}

	public void setDao(DAO<C> dao) {
		this.dao = dao;
	}

	public void setEntityClass(C entityClass) {
		this.entityClass = entityClass;
	}

	public void setEntityClassDelete(C entityClassDelete) {
		this.entityClassDelete = entityClassDelete;
	}

	public void setEntityClassEdit(C entityClassEdit) {
		this.entityClassEdit = entityClassEdit;
	}

	public void setEntityClassList(ListDataModel<C> entityClassList) {
		this.entityClassList = entityClassList;
	}

	@Override
	public void setFiltered(List<C> list) {
		filtered = list;
	}

	@Override
	public String update() {
		dao.save(entityClassEdit);
		entityClassList.setWrappedData(this.dao.all());
		return getNavigationString(new ListDirection());
	}

}
