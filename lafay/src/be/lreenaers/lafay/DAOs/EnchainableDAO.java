/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;

import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Niveau;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
public class EnchainableDAO extends DAO<Enchainable> {

	public EnchainableDAO(Class<Enchainable> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Enchainable entity) {
		NiveauDAO ndao = DAOFactory.getNiveauDAO();
		List<Niveau> nivs = ds.find(Niveau.class).field("enchainables").hasThisElement(entity).asList();
		Iterator<Niveau> it = nivs.iterator();
		Niveau niv;
		List<Enchainable> enchs;
		while(it.hasNext()){
			niv =it.next();
			enchs = niv.getEnchainable();
			enchs.remove(entity);
			niv.setEnchainables(enchs);
			ndao.save(niv);
		}
		
	}

	
}
