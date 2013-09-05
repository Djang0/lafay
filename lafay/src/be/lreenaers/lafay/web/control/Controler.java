package be.lreenaers.lafay.web.control;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.DAO;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

public abstract class Controler<C> 
	implements Controlable, RowEditable,
	Filterable<C>{
	protected DAO<C> dao;
	protected C entityClass;
	protected C entityClassEdit;
	protected List<C> filtered;
	protected ListDataModel<C> entityClassList;
	
	public Controler(Class<C> entityClass) {
		
		try {
			this.selectDAO();
			this.entityClassEdit = entityClass.newInstance();
			this.entityClass = entityClass.newInstance();
			this.entityClassList = new ListDataModel<C>();
			this.entityClassList.setWrappedData(this.dao.all());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<C> getFiltered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFiltered(List<C> list) {
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
