package be.lreenaers.lafay.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

@FacesConverter(forClass=Permission.class,value="permissionConverter")
public class PermissionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PermissionDAO dao = DAOFactory.getPermissionDAO();
		return dao.findById(new ObjectId(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Permission)arg2).getId().toString();
	}

}
