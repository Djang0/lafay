/**
 * 
 */
package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author ludo
 * 
 */
@ManagedBean(name = "permissionCtrl")
@SessionScoped
public class PermissionCtrl extends Controler<Permission> {

	public PermissionCtrl() {
		super(Permission.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getPermissionDAO();

	}
}