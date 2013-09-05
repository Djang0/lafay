/**
 * 
 */
package be.lreenaers.lafay.DAOs;

import be.lreenaers.lafay.beans.Enchainable;

/**
 * @author media
 * 
 */
@Deprecated
public class EnchainableDAO extends DAO<Enchainable> {

	public EnchainableDAO(Class<Enchainable> entityClass) {
		super(entityClass);
	}
}
