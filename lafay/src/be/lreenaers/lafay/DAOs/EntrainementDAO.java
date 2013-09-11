/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Cible;
import be.lreenaers.lafay.beans.Entrainement;
import be.lreenaers.lafay.beans.Serie;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class EntrainementDAO extends DAO<Entrainement> {

	public EntrainementDAO(Class<Entrainement> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Entrainement entity) {
		SerieDAO sdao = DAOFactory.getSerieDAO();
		CibleDAO cdao = DAOFactory.getCibleDAO();
		sdao.delete(ds.find(Serie.class).field("entrainement").hasThisElement(entity).asList());
		cdao.delete(ds.find(Cible.class).field("entrainement").hasThisElement(entity).asList());
	}
}
