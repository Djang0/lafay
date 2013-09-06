/**
 * 
 */
package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
@ManagedBean(name = "utilisateurCtrl")
@SessionScoped
public class UtilisateurCtrl extends Controler<Utilisateur> {
	public UtilisateurCtrl() {
		super(Utilisateur.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getUtilisateurDAO();

	}

}