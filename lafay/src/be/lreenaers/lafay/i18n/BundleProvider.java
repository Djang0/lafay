/**
 * 
 */
package be.lreenaers.lafay.i18n;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

/**
 * @author media
 * 
 */
public class BundleProvider {
	private static ResourceBundle bundle;

	public static ResourceBundle getBundle() {
		if (null == bundle) {
			Locale locale = FacesContext.getCurrentInstance().getViewRoot()
					.getLocale();
			bundle = PropertyResourceBundle.getBundle(
					"be.lreenaers.lafay.i18n.i18n", locale);
		}
		return bundle;
	}

	private BundleProvider() {
	}
}
