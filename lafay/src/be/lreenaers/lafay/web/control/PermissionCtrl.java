/**
 * 
 */
package be.lreenaers.lafay.web.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author ludo
 *
 */
@ManagedBean(name="permissionCtrl")
@SessionScoped
public class PermissionCtrl {
	private PermissionDAO dao = DAOFactory.getPermissionDAO();
	private ListDataModel<Permission> permissions = new ListDataModel<Permission>();
	private Permission permission = new Permission();
	private Permission permissionEdit = new Permission();
	
	public String delete(){
		Permission p = (Permission) permissions.getRowData();
		this.dao.delete(p);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
	public String update(){
		Permission u = (Permission) permissions.getRowData();
		this.dao.save(u);
		this.permissions.setWrappedData(this.dao.all());
		return "goPermList";
	}
	public String modify(){
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
	public String editPermission(){
	
		this.permissionEdit = (Permission) permissions.getRowData();
		return "editPerm";
	}
	
	
	
	public PermissionDAO getDao() {
		return dao;
	}
	public void setDao(PermissionDAO dao) {
		this.dao = dao;
	}
	public ListDataModel<Permission> getPermissions() {
		if(this.permissions == null){
			this.permissions = new ListDataModel<Permission>();
		}
		this.permissions.setWrappedData(this.dao.all());
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
