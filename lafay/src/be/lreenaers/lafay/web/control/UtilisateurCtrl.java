/**
 * 
 */
package be.lreenaers.lafay.web.control;

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
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.factories.DAOFactory;
import be.lreenaers.lafay.web.interfaces.Controlable;
import be.lreenaers.lafay.web.interfaces.Filterable;
import be.lreenaers.lafay.web.interfaces.RowEditable;

/**
 * @author media
 *
 */
@ManagedBean(name = "utilisateurCtrl")
@SessionScoped
public class UtilisateurCtrl implements Controlable, RowEditable, Filterable<Utilisateur>{
	/**
	 * 
	 */
	
	private UtilisateurDAO dao;
	private GroupeDAO gdao;
	private ListDataModel<Utilisateur> utilisateurs;
	private Utilisateur utilisateur;
	private Utilisateur utilisateurEdit;
	private List<Utilisateur> filtered;
	private DualListModel<Groupe> pickEditGroups;
	
	public UtilisateurCtrl(){
		dao = DAOFactory.getUtilisateurDAO();
		this.gdao = DAOFactory.getGroupeDAO();
		utilisateurs = new ListDataModel<Utilisateur>();
		utilisateur = new Utilisateur();
		utilisateurEdit = new Utilisateur();
		this.utilisateurs.setWrappedData(this.dao.all());
	}
	
	public String create(){
		this.dao.save(this.utilisateur);
		this.utilisateur = new Utilisateur();
		this.utilisateurs.setWrappedData(this.dao.all());
		return "userCreatedd";
	}
	public String delete(){
		Utilisateur u = (Utilisateur) utilisateurs.getRowData();
		this.dao.delete(u);
		this.utilisateurs.setWrappedData(this.dao.all());
		return "goUserList";
	}
	public String editUtilisateur(){
		this.utilisateurEdit = (Utilisateur) utilisateurs.getRowData();
		return "editUser";
	}
	@Override
	public List<Utilisateur> getFiltered() {
		return this.filtered;
	}
	public DualListModel<Groupe> getPickEditGroups() {
		List<Groupe> target = this.utilisateurEdit.getGroups();
		List<Groupe> source = this.gdao.all();
		source.removeAll(target);
		this.pickEditGroups = new DualListModel<Groupe>(source, target);
		return this.pickEditGroups;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public Utilisateur getUtilisateurEdit() {
		return utilisateurEdit;
	}
	public ListDataModel<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}
	public String goCreate(){
		return "createUser";
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
	public void onCancel(RowEditEvent event) {  
        //FacesMessage msg = new FacesMessage("Car Cancelled", ((Utilisateur) event.getObject()).getPrenom());  
  
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }

	public void onEdit(RowEditEvent event) {  
        this.dao.save((Utilisateur) event.getObject());
    }

	public void onTransferEdit(TransferEvent event) { 
		List<Groupe> g = this.utilisateurEdit.getGroups();
		for(Object item : event.getItems()){
			Groupe grp = (Groupe) item;
			g.add(grp);
		}
		this.utilisateurEdit.setGroups(g);
	}

	@Override
	public void setFiltered(List<Utilisateur> list) {
		this.filtered = list;
		
	}
	
	public void setPickEditPerms(DualListModel<Groupe> pickEditGroups) {
		this.pickEditGroups = pickEditGroups;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}  
      
    public void setUtilisateurEdit(Utilisateur utilisateurEdit) {
		this.utilisateurEdit = utilisateurEdit;
	}
	public void setUtilisateurs(ListDataModel<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public String update(){
		this.dao.save(this.utilisateurEdit);
		this.utilisateurs.setWrappedData(this.dao.all());
		return "goUserList";
	}  
	
}