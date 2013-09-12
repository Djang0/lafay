/**
 * 
 */
package be.lreenaers.lafay.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.i18n.BundleProvider;

/**
 * @author media
 * 
 */
@FacesValidator("be.lreenaers.lafay.web.validators.UniqueEmailValidator")
public class UniqueEmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) {

		UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
		Utilisateur usr = dao.findByEmail(value.toString());
		String err = BundleProvider.getBundle().getString(
				"user.email.notunique");
		if (usr != null) {
			FacesMessage msg = new FacesMessage(err);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}