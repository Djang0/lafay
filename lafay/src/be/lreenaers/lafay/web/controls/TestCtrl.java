package be.lreenaers.lafay.web.controls;

import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

public class TestCtrl extends Controler<Permission> {
	public TestCtrl() {
		super(Permission.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getPermissionDAO();

	}

}
