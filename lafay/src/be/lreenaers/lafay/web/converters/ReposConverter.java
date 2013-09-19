package be.lreenaers.lafay.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.DAOs.ReposDAO;
import be.lreenaers.lafay.beans.Repos;
import be.lreenaers.lafay.factories.DAOFactory;

@FacesConverter(forClass = Repos.class, value = "reposConverter")
public class ReposConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ReposDAO dao = DAOFactory.getReposDAO();
		return dao.findById(new ObjectId(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String str = "null";
		if (arg2 != null) {
			str = ((Repos) arg2).getId().toString();
		}
		return str;
	}

}
