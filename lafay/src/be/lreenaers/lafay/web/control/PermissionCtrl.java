/**
 * 
 */
package be.lreenaers.lafay.web.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

/**
 * @author ludo
 *
 */
@ManagedBean(name="permissionCtrl")
@SessionScoped
public class PermissionCtrl implements Controlable, RowEditable{
	// TODO:  implements Controlable, RowEditable for other COntrolers
	private PermissionDAO dao;
	private ListDataModel<Permission> permissions;
	private Permission permission;
	private Permission permissionEdit;
	
	public PermissionCtrl(){
		this.dao = DAOFactory.getPermissionDAO();
		this.permissions = new ListDataModel<Permission>();
		this.permissions.setWrappedData(this.dao.all());
		this.permission = new Permission();
		this.permissionEdit = new Permission();
	}
	public String delete(){
		Permission p = (Permission) permissions.getRowData();
		this.dao.delete(p);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
	public String update(){
		this.dao.save(this.permissionEdit);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
	public String create(){
		this.dao.save(this.permission);
		this.permission = new Permission();
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
	public void onEdit(RowEditEvent event){
		 this.permissionEdit = (Permission) event.getObject();
		 this.update();
	}
	public void onCancel(RowEditEvent event){
		
	}
	
	
	public PermissionDAO getDao() {
		return dao;
	}
	public void setDao(PermissionDAO dao) {
		this.dao = dao;
	}
	public ListDataModel<Permission> getPermissions() {
		return this.permissions;
	}
	public void setPermissions(ListDataModel<Permission> permissions) {
		this.permissions = permissions;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Permission getPermissionEdit() {
		return permissionEdit;
	}
	public void setPermissionEdit(Permission permissionEdit) {
		this.permissionEdit = permissionEdit;
	}
	
	
}
