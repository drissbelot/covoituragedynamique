package com.covoiturage.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;

import org.datanucleus.jpa.annotations.Extension;

import com.covoiturage.server.BCrypt;
import com.covoiturage.server.EMF;

@Entity
public class UserInfo {

	public static long countUsers() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from UserInfo o")
					.getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<UserInfo> findAllUsers() {
		EntityManager em = entityManager();
		try {
			List<UserInfo> list = em.createQuery("select o from UserInfo o")
					.getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static UserInfo findUserInfo(String id) {

		EntityManager em = entityManager();
		try {
			UserInfo user = em.find(UserInfo.class, id);
			return user;
		} finally {
			em.close();
		}
	}

	public String persist() {
		EntityManager em = entityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(this);
			em.flush();
			tx.commit();

		} finally {

			em.close();

		}
		return this.id;
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

	public static UserInfo modifyUserInfo(String id, String password,
			String emailAddress) {
		UserInfo user = new UserInfo();
		EntityManager em = entityManager();

		Query query = em
				.createQuery("select o from UserInfo o where o.id = :idParam ");
		query.setParameter("idParam", id);

		try {

			@SuppressWarnings("unchecked")
			List<UserInfo> results = query.getResultList();

			if (results.size() == 0) {
				return null;
			} else {

				user = results.get(0);

				em.getTransaction().begin();

				user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
				user.setEmailAddress(emailAddress);

				em.getTransaction().commit();

			}
		} finally {
			em.close();
		}

		return user;
	}

	public static boolean logout(String id) {
		EntityManager em = entityManager();
		try {
			UserInfo user = em.find(UserInfo.class, id);
			em.getTransaction().begin();
			user.setLoggedIn(false);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return true;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String id;

	public String login;

	public String emailAddress;

	private String password;

	private boolean loggedIn = false;

	@Version
	@Column(name = "version")
	private Integer version = 0;

	public UserInfo() {
	}

	public UserInfo(String id, String login, String emailAddress,
			String password) {
		this.id = id;
		this.login = login;
		this.setPassword(password);

		this.emailAddress = emailAddress;
	}

	public boolean getLoggedIn() {
		return loggedIn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static UserInfo getDefaultUser() {

		return null;
	}

	public void setLoggedIn(boolean b) {
		loggedIn = b;

	}

	public void setPassword(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());

		this.password = hash;
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
