/**
 * 
 */
package be.lreenaers.lafay.web.control;

import com.mongodb.DBCursor;

import be.lreenaers.lafay.DAOs.EnchainableDAO;
import be.lreenaers.lafay.factories.DAOFactory;



/**
 * @author media
 *
 */
public class EnchainableCtrl {
	private EnchainableDAO dao = DAOFactory.getEnchainableDAO();
	private DBCursor enchainables;
		
}
