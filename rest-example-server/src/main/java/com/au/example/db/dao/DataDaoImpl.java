package com.au.example.db.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQueryCreator;

import com.au.example.db.model.Data;

@Stateless
public class DataDaoImpl implements DataDao{
	
	@PersistenceContext(name="MyAppUnit")
	private EntityManager em;
	
	
	public Data findById(Integer id){
		return em.find(Data.class, id);
	}

	public void create(Data data){
		em.persist(data);
	}
	
	@Override
	public List<?> getAllAuditData() {
		AuditReader auditReader = AuditReaderFactory.get(em);
		AuditQueryCreator auditQueryCreator =  auditReader.createQuery();
		List<?> l = auditQueryCreator.forRevisionsOfEntity(Data.class, false, false).getResultList();
		return l;
		
		
	}

	@Override
	public List<Data> getAuditData(Integer id) {
		AuditReader auditReader = AuditReaderFactory.get(em);
		AuditQueryCreator auditQueryCreator =  auditReader.createQuery();
		List<Data> l = auditQueryCreator.forRevisionsOfEntity(Data.class, true, false).add(AuditEntity.id().eq(id)).getResultList();
		return l;
		
	}

	@Override
	public List<Data> getAuditDataUseDataDetialId(Integer dataDetialId) {
		// TODO Auto-generated method stub
		AuditReader auditReader = AuditReaderFactory.get(em);
		AuditQueryCreator auditQueryCreator =  auditReader.createQuery();
		List<Data> l = auditQueryCreator.forRevisionsOfEntity(Data.class, true, false).add(AuditEntity.relatedId("detialSet").eq(dataDetialId)).getResultList();
		return l;
		
	}
	
	

}
