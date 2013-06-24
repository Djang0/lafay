/**
 * 
 */
package be.lreenaers.lafay.factories;

import be.lreenaers.lafay.DAOs.EnchainableDAO;
import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.beans.Groupe;


/**
 * @author media
 *
 */
public class DAOFactory {
	private static EnchainableDAO enchainable;
	private static UtilisateurDAO utilisateur;
	private static PermissionDAO permission;
	private static GroupeDAO groupe;
	private DAOFactory(){}
	
	public static GroupeDAO getGroupeDAO(){
		if(groupe == null){
			groupe = new GroupeDAO(Groupe.class);
		}
		return groupe;
	}
	public static EnchainableDAO getEnchainableDAO(){
		if(enchainable == null){
			enchainable = new EnchainableDAO(Enchainable.class);
		}
		return enchainable;
	}
	public static UtilisateurDAO getUtilisateurDAO(){
		if(utilisateur == null){
			utilisateur = new UtilisateurDAO(Utilisateur.class);
		}
		return utilisateur;
	}

	public static PermissionDAO getPermissionDAO() {
		if(permission == null){
			permission = new PermissionDAO(Permission.class);
		}
		return permission;
	}
}
