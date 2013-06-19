/**
 * 
 */
package be.lreenaers.lafay.web.control;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 *
 */
public class UtilisateurCtrl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO dao;
	private ListDataModel<Utilisateur> utilisateurs;
	private Utilisateur utilisateur;
	private Utilisateur utilisateurEdit;
	public UtilisateurCtrl(){
		
		dao = DAOFactory.getUtilisateurDAO();
		utilisateurs = new ListDataModel<Utilisateur>();
		utilisateur = new Utilisateur();
		utilisateurEdit = new Utilisateur();
		this.utilisateurs.setWrappedData(this.dao.all());
	}
	public Utilisateur getUtilisateurEdit() {
		return utilisateurEdit;
	}
	public void setUtilisateurEdit(Utilisateur utilisateurEdit) {
		this.utilisateurEdit = utilisateurEdit;
	}
	public String delete(){
		Utilisateur u = (Utilisateur) utilisateurs.getRowData();
		this.dao.delete(u);
		this.utilisateurs.setWrappedData(this.dao.all());
		return "goUserList";
	}
	public String update(){
		Utilisateur u = (Utilisateur) utilisateurs.getRowData();
	
		this.dao.save(u);
		this.utilisateurs.setWrappedData(this.dao.all());
		return "goUserList";
	}
	public String modify(){
		this.dao.save(this.utilisateurEdit);
		this.utilisateurs.setWrappedData(this.dao.all());
		return "goUserList";
	}
	public String create(){
		this.dao.save(this.utilisateur);
		this.utilisateur = new Utilisateur();
		this.utilisateurs.setWrappedData(this.dao.all());
		return "userCreatedd";
	}
	public String editUtilisateur(){
	
		this.utilisateurEdit = (Utilisateur) utilisateurs.getRowData();
		return "editUser";
	}
	public ListDataModel<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(ListDataModel<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String login(){
		this.utilisateur = this.dao.findByEmail(this.utilisateur.getEmail());
		String returned = "";
		try {
			if(this.utilisateur != null && MessageDigest.getInstance("MD5").digest(this.utilisateur.getPasse().getBytes()).equals(this.utilisateur.getHash().getBytes())){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilisateur", this.utilisateur);
				returned = "authorized";		
			}
			else{
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilisateur", null);
				returned = "rejected";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returned;
	}
	
	public void onEdit(RowEditEvent event) {  
        this.dao.save((Utilisateur) event.getObject());
    }  
      
    public void onCancel(RowEditEvent event) {  
        //FacesMessage msg = new FacesMessage("Car Cancelled", ((Utilisateur) event.getObject()).getPrenom());  
  
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
}