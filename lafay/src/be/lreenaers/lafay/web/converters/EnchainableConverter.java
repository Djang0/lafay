package be.lreenaers.lafay.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bson.types.ObjectId;

import be.lreenaers.lafay.DAOs.EnchainableDAO;
import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.factories.DAOFactory;

@FacesConverter(forClass = Enchainable.class, value = "enchainableConverter")
public class EnchainableConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		EnchainableDAO dao = DAOFactory.getEnchainableDAO();
		return dao.findById(new ObjectId(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Enchainable) arg2).getId().toString();
	}
}
