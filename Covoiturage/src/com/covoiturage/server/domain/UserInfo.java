package com.covoiturage.server.domain;





import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;

import com.covoiturage.server.EMF;
import com.covoiturage.server.MapUtils;
import com.google.gwt.requestfactory.server.RequestFactoryServlet;

@Entity
public class UserInfo{

	public static long countUsers() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from UserInfo o").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<UserInfo> findAllUsers() {
		EntityManager em = entityManager();
		try {
			List<UserInfo> list = em.createQuery("select o from UserInfo o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static UserInfo findUser(Long id) {
		if (id == null) {
			return null;
		}
		EntityManager em = entityManager();
		try {
			UserInfo user = em.find(UserInfo.class, id);
			return user;
		} finally {
			em.close();
		}
	}

	public void persist() {
		EntityManager em = entityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
	}

	public void remove() {
		EntityManager em = entityManager();
		try {
			UserInfo attached = em.find(UserInfo.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}


	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
	public List<UserInfo> getPassengers(List<String> steps, float distance) {
		return MapUtils.bufferRoute(steps, distance);
		

	}


	public UserInfo login(String login, String password) {


		UserInfo user = new UserInfo();
		EntityManager em = entityManager();
		Query query= em.createQuery("select o from UserInfo where o login =:loginParam && password =:passwordParam");
		query.setParameter("loginParam",login);
		query.setParameter("passwordParam",password);
		try
		{

			@SuppressWarnings("unchecked")
			List<UserInfo> results =query.getResultList();
	
			if(results.size()==0){
				return null;
			}
			else 
			{

				user= results.get(0);
			}
		}
		finally
		{
			em.close();
		}


		user.setLogin(login);
		user.setLoggedIn(true);
		//setUserInSession(user);
		return user;


	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String login;

	public String emailAddress;
	private String loginUrl;
	private String logoutUrl;

	private String password;

	private boolean loggedIn = false;

	@Version
	@Column(name = "version")
	private Integer version = 0;



	public UserInfo() {}

	public UserInfo(Long id, String login, String emailAddress, String password) {
		this.id = id;
		this.login = login;
		this.setPassword(password);

		this.emailAddress = emailAddress;
	}
	public boolean getLoggedIn() {
		return loggedIn;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getLogin() { return login; }

	public void setLogin(String login) { this.login= login; }
	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }


	public static UserInfo getDefaultUser() {

		return null;
	}


	public void setLoggedIn(boolean b) {
		loggedIn=b;

	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

}