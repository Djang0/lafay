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
	public void prt(){
		System.out.println(this.dao.all().toString());
	}

	@Override
	public String getNavList() {
		// TODO Auto-generated method stub
		return null;
	}

}
