package be.lreenaers.lafay.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.DAOs.MouvementDAO;
import be.lreenaers.lafay.beans.Mouvement;
import be.lreenaers.lafay.factories.DAOFactory;

@FacesConverter(forClass = Mouvement.class, value = "mouvementConverter")
public class MouvementConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		MouvementDAO dao = DAOFactory.getMouvementDAO();
		
		return dao.findById(new ObjectId(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String str = "null";
		if (arg2 != null) {
			str = ((Mouvement) arg2).getId().toString();
		}

		return str;
	}

}
