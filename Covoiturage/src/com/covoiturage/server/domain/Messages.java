package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.datanucleus.jpa.annotations.Extension;

import com.covoiturage.server.EMF;

@Entity
public class Messages {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String id;

	public String getId() {
		return id;
	}

	private String message;
	private boolean read;
	private String subject;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private String from;
	private Date date;

	@Version
	@Column(name = "version")
	private Integer version = 0;

	public Integer getVersion() {
		return version;
	}

	public static final EntityManager entityManager() {

		return EMF.get().createEntityManager();

	}

	public Messages() {
	}

	public Messages(String id, String message, boolean read, String from,
			Date date) {
		this.id = id;
		this.setMessage(message);
		this.setRead(read);
		this.setFrom(from);
		this.setDate(date);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean getRead() {
		return read;
	}

	public static Messages findMessages(String id) {

		EntityManager em = entityManager();
		try {
			Messages message = em.find(Messages.class, id);
			return message;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Messages> findAllMessages() {
		EntityManager em = entityManager();
		try {
			List<Messages> list = em.createQuery("select o from Messages o")
					.getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static long countMessages() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from Messages o")
					.getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	public String persist() {
		EntityManager em = entityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
		return this.id;
	}

	public void remove() {
		EntityManager em = entityManager();
		try {
			Messages attached = em.find(Messages.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
}
