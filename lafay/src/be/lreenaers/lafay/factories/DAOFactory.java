/**
 * 
 */
package be.lreenaers.lafay.factories;

import java.lang.reflect.InvocationTargetException;

import be.lreenaers.lafay.DAOs.CibleDAO;
import be.lreenaers.lafay.DAOs.DAO;
import be.lreenaers.lafay.DAOs.EnchainableDAO;
import be.lreenaers.lafay.DAOs.EntrainementDAO;
import be.lreenaers.lafay.DAOs.ExerciceDAO;
import be.lreenaers.lafay.DAOs.GroupeDAO;
import be.lreenaers.lafay.DAOs.MouvementDAO;
import be.lreenaers.lafay.DAOs.NiveauDAO;
import be.lreenaers.lafay.DAOs.PermissionDAO;
import be.lreenaers.lafay.DAOs.ReposDAO;
import be.lreenaers.lafay.DAOs.SerieDAO;
import be.lreenaers.lafay.DAOs.UtilisateurDAO;
import be.lreenaers.lafay.beans.Cible;
import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Entrainement;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Mouvement;
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
	private static CibleDAO cible;
	@Deprecated
	private static EnchainableDAO enchainable;
	private static EntrainementDAO entrainement;
	private static ExerciceDAO exercice;
	private static GroupeDAO groupe;
	private static MouvementDAO mouvement;
	private static NiveauDAO niveau;
	private static PermissionDAO permission;
	private static ReposDAO repos;
	private static SerieDAO serie;
	private static UtilisateurDAO utilisateur;

	public static CibleDAO getCibleDAO() {
		if (cible == null) {
			cible = new CibleDAO(Cible.class);
		}
		return cible;
	}

	@Deprecated
	public static EnchainableDAO getEnchainableDAO() {
		if (enchainable == null) {
			enchainable = new EnchainableDAO(Enchainable.class);
		}
		return enchainable;
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

	public static MouvementDAO getMouvementDAO() {
		if (mouvement == null) {
			mouvement = new MouvementDAO(Mouvement.class);
		}
		return mouvement;
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

	public static ReposDAO getReposDAO() {
		if (repos == null) {
			repos = new ReposDAO(Repos.class);
		}
		return repos;
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

	// public static DAO getFactory(Class factoryClass,Class beanClass) throws
	// InstantiationException, IllegalAccessException, IllegalArgumentException,
	// InvocationTargetException, NoSuchMethodException, SecurityException{
	// System.out.println(beanClass.getName());
	// return (DAO) factoryClass.getConstructor(beanClass).newInstance();
	// }

	private DAOFactory() {
	}
}
