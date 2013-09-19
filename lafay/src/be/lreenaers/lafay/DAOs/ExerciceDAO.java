/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;

import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Exercice;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class ExerciceDAO extends DAO<Exercice> {

	public ExerciceDAO(Class<Exercice> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Exercice entity) {
		EnchainableDAO edao = DAOFactory.getEnchainableDAO();
		List<Enchainable> enchs = ds.find(Enchainable.class).field("exercice")
				.hasThisElement(entity).asList();
		Iterator<Enchainable> it = enchs.iterator();
		Enchainable ench;
		while (it.hasNext()) {
			ench = it.next();
			ench.setExercice(null);
			edao.save(ench);
		}

	}
}
