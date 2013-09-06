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

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import be.lreenaers.lafay.beans.Groupe;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.directions.BoardDirection;
import be.lreenaers.lafay.web.directions.Direction;
import be.lreenaers.lafay.web.directions.ForbidenDirection;
import be.lreenaers.lafay.web.utils.EntityPicklist;

/**
 * @author media
 * 
 */
@ManagedBean(name = "utilisateurCtrl")
@SessionScoped
public class UtilisateurCtrl extends Controler<Utilisateur> {
	
	private EntityPicklist<Groupe> pickG;
	
	public UtilisateurCtrl() {
		super(Utilisateur.class);
		this.entityClassList.setWrappedData(this.dao.all());
		this.pickG = new EntityPicklist<Groupe>(DAOFactory.getGroupeDAO());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getUtilisateurDAO();

	}
	public String login(){
		this.entityClass = this.dao.findOne("email",this.entityClass.getEmail());
		Direction returned = new ForbidenDirection();
		try {
			if(this.entityClass != null && MessageDigest.getInstance("MD5").digest(this.entityClass.getPasse().getBytes()).equals(this.entityClass.getHash().getBytes())){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilisateur", this.entityClass);
				returned = new BoardDirection();		
			}
			else{
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilisateur", null);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getNavigationString(returned);
	}
	public void onTransferEdit(TransferEvent event) { 
		List<Groupe> g = this.entityClassEdit.getGroups();
		this.entityClassEdit.setGroups(this.pickG.getTransfered(event,g));
	}
	public void setPickEdit(DualListModel<Groupe> pickEditGroups) {
		this.pickG.setPicks(pickEditGroups);
	}
	public DualListModel<Groupe> getPickEdit() {
		return this.pickG.getPicks(this.entityClassEdit.getGroups());
	}
	
}