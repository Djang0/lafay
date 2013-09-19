/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Cible;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.beans.Mouvement;
import be.lreenaers.lafay.beans.Serie;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class MouvementDAO extends DAO<Mouvement> {

	public MouvementDAO(Class<Mouvement> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Mouvement entity) {
		SerieDAO sdao = DAOFactory.getSerieDAO();
		CibleDAO cdao = DAOFactory.getCibleDAO();
		ExerciceDAO edao = DAOFactory.getExerciceDAO();
		sdao.delete(ds.find(Serie.class).field("mouvement")
				.hasThisElement(entity).asList());
		cdao.delete(ds.find(Cible.class).field("mouvement")
				.hasThisElement(entity).asList());
		edao.delete(ds.find(Exercice.class).field("mouvement")
				.hasThisElement(entity).asList());
	}
}
