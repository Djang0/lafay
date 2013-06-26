/**
 * 
 */
package be.lreenaers.lafay.web.control;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

/**
 * @author ludo
 * 
 */
@ManagedBean(name = "permissionCtrl")
@SessionScoped
public class PermissionCtrl implements Controlable, RowEditable,
		Filterable<Permission> {
	private PermissionDAO dao;
	private GroupeDAO gdao;
	private ListDataModel<Permission> permissions;
	private Permission permission;
	private Permission permissionEdit;
	private List<Permission> filtered;

	public PermissionCtrl() {
		this.dao = DAOFactory.getPermissionDAO();
		this.permissions = new ListDataModel<Permission>();
		this.permissions.setWrappedData(this.dao.all());
		this.permission = new Permission();
		this.permissionEdit = new Permission();

	}

	public String create() {
		this.dao.save(this.permission);
		this.permission = new Permission();
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}

	public String delete() {
		this.gdao = DAOFactory.getGroupeDAO();
		Permission p = (Permission) permissions.getRowData();
		List<Groupe> groups = gdao.all();
		Iterator<Groupe> it = groups.iterator();
		Groupe g;
		List<Permission> perms;
		while (it.hasNext()) {
			g = it.next();
			perms = g.getPermissions();
			perms.remove(p);
			g.setPermissions(perms);
			this.gdao.save(g);
		}
		this.dao.delete(p);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}

	public PermissionDAO getDao() {
		return dao;
	}

	public List<Permission> getFiltered() {
		return filtered;
	}

	public Permission getPermission() {
		return permission;
	}

	public Permission getPermissionEdit() {
		return permissionEdit;
	}

	public ListDataModel<Permission> getPermissions() {
		return this.permissions;
	}

	public String goCreate() {
		return "goCreatePerm";
	}

	public void onCancel(RowEditEvent event) {

	}

	public void onEdit(RowEditEvent event) {
		this.dao.save((Permission) event.getObject());
		// this.update();
	}

	public void setDao(PermissionDAO dao) {
		this.dao = dao;
	}

	public void setFiltered(List<Permission> filtered) {
		this.filtered = filtered;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setPermissionEdit(Permission permissionEdit) {
		this.permissionEdit = permissionEdit;
	}

	public void setPermissions(ListDataModel<Permission> permissions) {
		this.permissions = permissions;
	}

	public String update() {
		this.dao.save(this.permissionEdit);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
}