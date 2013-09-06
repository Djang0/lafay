/**
 * 
 */
package be.lreenaers.lafay.web.controls;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.Modifiable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

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