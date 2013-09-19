package be.lreenaers.lafay.DAOs;

import java.util.Iterator;
import java.util.List;

import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.beans.Repos;
import be.lreenaers.lafay.factories.DAOFactory;

public class ReposDAO extends DAO<Repos> {

	public ReposDAO(Class<Repos> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteRelatedAncestors(Repos entity) {
		EnchainableDAO edao = DAOFactory.getEnchainableDAO();
		List<Enchainable> enchs = ds.find(Enchainable.class).field("repos")
				.hasThisElement(entity).asList();
		Iterator<Enchainable> it = enchs.iterator();
		Enchainable ench;
		while (it.hasNext()) {
			ench = it.next();
			ench.setRepos(null);
			edao.save(ench);
		}

	}

}
