/**
 * 
 */
package be.lreenaers.lafay.web.security;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author media
 *
 */
public class AuthorizationListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void afterPhase(PhaseEvent event) {
		/* TODO : Authorization process
		 * FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		 
		int isLoginPage = currentPage.lastIndexOf("index.xhtml");
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object currentUser = session.getAttribute("username");
		 
		if (isLoginPage==0 && (currentUser == null || currentUser == "")) {
		NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
		nh.handleNavigation(facesContext, null, "loginPage");
		}*/
		
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		
		boolean authorized = true ;
		if (!authorized && ! currentPage.equals("/utilisateur/interdit.xhtml")){
			NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
			nh.handleNavigation(facesContext, null, "unauthorized");
		}

	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
