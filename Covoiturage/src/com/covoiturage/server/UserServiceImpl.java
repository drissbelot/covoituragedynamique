package com.covoiturage.server;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.covoiturage.client.UserService;
import com.covoiturage.server.domain.UserInfo;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class UserServiceImpl extends RemoteServiceServlet implements UserService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String login(String login, String password) {
		EntityManager em = EMF.get().createEntityManager();
		UserInfo user = new UserInfo();
		Query query= em.createQuery("select o from UserInfo o where o.login = :loginParam ");
		query.setParameter("loginParam",login);

		try
		{
			@SuppressWarnings("unchecked")
			List<UserInfo> results =query.getResultList();

			if(results.size()==0){
				return null;
			}
			else 
			{
				if(BCrypt.checkpw(password, results.get(0).getPassword())){
					user= results.get(0);

					em.getTransaction().begin();
					
					
					user.setLoggedIn(true);

					em.getTransaction().commit();	
					HttpSession httpSession= getThreadLocalRequest().getSession();
					httpSession.setMaxInactiveInterval(1000 * 60 *2);
					httpSession.setAttribute("LOGGED_IN_USER", results.get(0).getId());
					return httpSession.getId();
				}
				else
					return null;
			}
		}
		finally
		{
			em.close();
		}
	}
	public String getUser(){
		HttpSession httpSession= getThreadLocalRequest().getSession();
		return (String)httpSession.getAttribute("LOGGED_IN_USER");
	}
	

}
