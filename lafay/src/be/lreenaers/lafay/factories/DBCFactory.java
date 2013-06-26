/**
 * 
 */
package be.lreenaers.lafay.factories;

import java.net.UnknownHostException;

import be.lreenaers.lafay.beans.Utilisateur;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * @author media
 * 
 */
public class DBCFactory {
	private static Datastore ds;

	public static Datastore getConnection() {
		if (null == ds) {
			Mongo mongo;
			try {
				mongo = new Mongo("localhost", 27017);
				Morphia dbc = new Morphia();
				// TODO : map all beans
				dbc.map(Utilisateur.class);
				ds = dbc.createDatastore(mongo, "lafay");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ds;
	}

	private DBCFactory() {
	}
}
