package be.lreenaers.lafay.web.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.Modifiable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

@ManagedBean(name="groupeCtrl")
@SessionScoped
public class GroupeCtrl implements Controlable, RowEditable, Filterable<Groupe>, Modifiable{
	private GroupeDAO dao;
	private PermissionDAO pdao;
	private List<Groupe> filtered;
	private Groupe groupeEdit;
	private Groupe groupe;
	private ListDataModel<Groupe> groupes;
	private DualListModel<Permission> pickCreatePerms;
	private DualListModel<Permission> pickEditPerms;
	
	public DualListModel<Permission> getPickCreatePerms() {
		List<Permission> target = new ArrayList<Permission>();
		List<Permission> source = this.pdao.all();
		source.removeAll(target);
		this.pickCreatePerms = new DualListModel<Permission>(source, target);
		return this.pickCreatePerms;
	}
	public void setPickCreatePerms(DualListModel<Permission> pickCreatePerms) {
		this.pickCreatePerms = pickCreatePerms;
	}
	public String goCreate(){
		return "goCreateGroup";
	}
	public DualListModel<Permission> getPickEditPerms() {
		List<Permission> target = this.groupeEdit.getPermissions();
		List<Permission> source = this.pdao.all();
		source.removeAll(target);
		this.pickEditPerms = new DualListModel<Permission>(source, target);
		return this.pickEditPerms;
	}
	public void setPickEditPerms(DualListModel<Permission> pickEditPerms) {
		this.pickEditPerms = pickEditPerms;
	}
	public GroupeCtrl(){
		this.dao = DAOFactory.getGroupeDAO();
		this.pdao = DAOFactory.getPermissionDAO();
		this.groupe = new Groupe();
		this.groupeEdit = new Groupe();
		this.groupes = new ListDataModel<Groupe>();
		this.groupes.setWrappedData(dao.all());
		
	}
	public Groupe getGroupeEdit() {
		return groupeEdit;
	}
	public void setGroupeEdit(Groupe groupeEdit) {
		this.groupeEdit = groupeEdit;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public ListDataModel<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(ListDataModel<Groupe> groupes) {
		this.groupes = groupes;
	}
	@Override
	public List<Groupe> getFiltered() {
		return this.filtered;
	}

	@Override
	public void setFiltered(List<Groupe> list) {
		this.filtered = list;
	}

	@Override
	public void onEdit(RowEditEvent event) {
		this.dao.save((Groupe) event.getObject());
	}

	@Override
	public void onCancel(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		Groupe g = (Groupe) this.groupes.getRowData();
		this.dao.delete(g);
		this.groupes.setWrappedData(dao.all());
		return "goGrpList";
	}

	@Override
	public String update() {
		this.dao.save(this.groupeEdit);
		this.groupes.setWrappedData(dao.all());
		return "goGrpList";
	}

	@Override
	public String create() {
		Iterator<Permission> i = this.groupe.getPermissions().iterator();
		while(i.hasNext()){
			Permission permission = i.next();
			System.out.println("saving:"+permission.getId().toString()+"//"+permission.getValeur());
		}
		this.dao.save(this.groupe);
		this.groupe = new Groupe();
		this.groupes.setWrappedData(dao.all());
		return "goGrpList";
	}
	public void onTransfer(TransferEvent event) { 
		List<Permission> p = this.groupe.getPermissions();
		for(Object item : event.getItems()){
			
			Permission perm = (Permission) item;
			p.add(perm);
			System.out.println("transfert:"+perm.getId().toString()+"//"+perm.getValeur());
			
			
		}
		this.groupe.setPermissions(p);
	}
	@Override
	public String edit() {
		this.groupeEdit = (Groupe) this.groupes.getRowData();
		return "goModGroup";
	}
}
