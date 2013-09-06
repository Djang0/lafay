/**
 * 
 */
package be.lreenaers.lafay.web.controls;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.lreenaers.lafay.beans.Enchainable;
import be.lreenaers.lafay.factories.DAOFactory;

/**
 * @author media
 * 
 */
@Deprecated
@ManagedBean(name = "enchainableCtrl")
@SessionScoped
public class EnchainableCtrl extends Controler<Enchainable> {

	public EnchainableCtrl() {
		super(Enchainable.class);
		this.entityClassList.setWrappedData(this.dao.all());
	}

	@Override
	public void selectDAO() {
		this.dao = DAOFactory.getEnchainableDAO();

	}
}
