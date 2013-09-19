package be.lreenaers.lafay.web.controls;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.utils.EntityPicklist;

@ManagedBean(name = "groupeCtrl")
@SessionScoped
public class GroupeCtrl extends Controler<Groupe> {
	private EntityPicklist<Permission> pickG;
	public GroupeCtrl() {
		super(Groupe.class);
		this.entityClassList.setWrappedData(this.dao.all());
		this.pickG = new EntityPicklist<Permission>(DAOFactory.getPermissionDAO());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getGroupeDAO();

	}
	public void onTransferEdit(TransferEvent event) { 
		List<Permission> g=this.pickG.getTransfered(event,this.entityClassEdit.getPermissions());
		this.entityClassEdit.setPermissions(g);
	}
	public void onTransferCreate(TransferEvent event) { 
		List<Permission> g=this.pickG.getTransfered(event,this.entityClass.getPermissions());
		this.entityClass.setPermissions(g);
	}
	public void setPickEdit(DualListModel<Permission> pickEditPerms) {
		this.pickG.setPicks(pickEditPerms);
		this.entityClassEdit.setPermissions(this.pickG.getTarget());
	}
	public DualListModel<Permission> getPickEdit() {
		return this.pickG.getPicks(this.entityClassEdit.getPermissions());
	}
	public DualListModel<Permission> getPickCreate() {
		return this.pickG.getPicks(this.entityClass.getPermissions());
	}
	
	public void setPickCreate(DualListModel<Permission> pickEditPerms) {
		this.pickG.setPicks(pickEditPerms);
		this.entityClass.setPermissions(this.pickG.getTarget());
	}
}
