package com.au.example.db.model.aud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity {

	@Id
	@GeneratedValue
	@RevisionNumber
	private int id;

	@RevisionTimestamp
	private long timestamp;

	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}