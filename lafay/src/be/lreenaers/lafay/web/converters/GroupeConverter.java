package be.lreenaers.lafay.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.factories.DAOFactory;

@FacesConverter(forClass=Permission.class,value="groupeConverter")
public class GroupeConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		GroupeDAO dao = DAOFactory.getGroupeDAO();
		return dao.findById(new ObjectId(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return (( Groupe )arg2).getId().toString();
	}
}
