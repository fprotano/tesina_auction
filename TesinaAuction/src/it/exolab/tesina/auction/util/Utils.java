package it.exolab.tesina.auction.util;

import javax.servlet.http.HttpSession;

public class Utils{
	

	
	public HttpSession sessionCleanerFromHelpdesk(HttpSession session) {
		session.removeAttribute("staff");
		return session;
	}

}
