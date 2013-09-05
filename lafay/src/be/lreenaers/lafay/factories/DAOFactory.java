/**
 * 
 */
package be.lreenaers.lafay.factories;

import be.lreenaers.lafay.DAOs.CibleDAO;
import be.lreenaers.lafay.DAOs.EnchainableDAO;
import be.lreenaers.lafay.DAOs.EntrainementDAO;
import be.lreenaers.lafay.DAOs.ExerciceDAO;
import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.NiveauDAO;
import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.DAOs.ReposDAO;
import be.lreenaers.lafay.DAOs.SerieDAO;
import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Cible;
import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Entrainement;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Niveau;
import be.lreenaers.lafay.beans.Permission;
import be.lreenaers.lafay.beans.Repos;
import be.lreenaers.lafay.beans.Serie;
import be.lreenaers.lafay.beans.Utilisateur;
import be.lreenaers.lafay.beans.Groupe;

/**
 * @author media
 * 
 */
@SuppressWarnings("deprecation")
public class DAOFactory {
	@Deprecated
	private static EnchainableDAO enchainable;
	private static UtilisateurDAO utilisateur;
	private static PermissionDAO permission;
	private static GroupeDAO groupe;
	private static EntrainementDAO entrainement;
	private static ExerciceDAO exercice;
	private static NiveauDAO niveau;
	private static SerieDAO serie;
	private static CibleDAO cible;
	private static ReposDAO repos;
	@Deprecated
	public static EnchainableDAO getEnchainableDAO() {
		if (enchainable == null) {
			enchainable = new EnchainableDAO(Enchainable.class);
		}
		return enchainable;
	}
	public static CibleDAO getCibleDAO() {
		if (cible == null) {
			cible = new CibleDAO(Cible.class);
		}
		return cible;
	}
	public static ReposDAO getReposDAO() {
		if (repos == null) {
			repos = new ReposDAO(Repos.class);
		}
		return repos;
	}
	public static EntrainementDAO getEntrainementDAO() {
		if (entrainement == null) {
			entrainement = new EntrainementDAO(Entrainement.class);
		}
		return entrainement;
	}

	public static ExerciceDAO getExerciceDAO() {
		if (exercice == null) {
			exercice = new ExerciceDAO(Exercice.class);
		}
		return exercice;
	}

	public static GroupeDAO getGroupeDAO() {
		if (groupe == null) {
			groupe = new GroupeDAO(Groupe.class);
		}
		return groupe;
	}

	public static NiveauDAO getNiveauDAO() {
		if (niveau == null) {
			niveau = new NiveauDAO(Niveau.class);
		}
		return niveau;
	}

	public static PermissionDAO getPermissionDAO() {
		if (permission == null) {
			permission = new PermissionDAO(Permission.class);
		}
		return permission;
	}

	public static SerieDAO getSerieDAO() {
		if (serie == null) {
			serie = new SerieDAO(Serie.class);
		}
		return serie;
	}

	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateur == null) {
			utilisateur = new UtilisateurDAO(Utilisateur.class);
		}
		return utilisateur;
	}

	private DAOFactory() {
	}
}
