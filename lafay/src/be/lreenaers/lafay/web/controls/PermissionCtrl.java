/**
 * 
 */
package be.lreenaers.lafay.web.controls;

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


/**
 * @author ludo
 * 
 */
@ManagedBean(name = "permissionCtrl")
@SessionScoped
public class PermissionCtrl extends Controler<Permission>  {

	public PermissionCtrl() {
		super(Permission.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	public String goCreate() {
		// TODO: create rules with class name and buble up method to Controler class
		return "goCreatePerm";
	}
	@Override
	public String getNavList() {
		// TODO: create rules with class name and buble up method to Controler class
		return "goPermList";
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getPermissionDAO();
		
	}
}