/**
 * 
 */
package be.lreenaers.lafay.web.validators;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
@FacesValidator("be.lreenaers.lafay.web.validators.UniquePseudoValidator")
public class UniquePseudoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) {

		UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
		Utilisateur usr = dao.findByPseudo(value.toString());
		Locale locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		ResourceBundle bundle = PropertyResourceBundle.getBundle(
				"be.lreenaers.lafay.i18n.i18n", locale);
		String err = bundle.getString("err_pseudo_not_unique");
		if (usr != null) {
			FacesMessage msg = new FacesMessage(err);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}