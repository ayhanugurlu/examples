package com.au.example.db.model.aud;

import org.hibernate.envers.RevisionListener;

public class UserRevisionListener implements RevisionListener {
	
	
	@Override
	public void newRevision(Object revisionEntity) {
		UserRevEntity exampleRevEntity = (UserRevEntity) revisionEntity;
		
		exampleRevEntity.setNickName("ayhan");
	}
}