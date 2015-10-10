package com.masterheboss.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.StaticMetamodel;

import com.masterheboss.globaleinterface.Identifiable;



public abstract class GenericRepository <T extends Identifiable<PK>, PK>{

@PersistenceContext
EntityManager em;

private Class<T> entityClass;

public GenericRepository(Class<T> entityClass) {
    this.entityClass = entityClass;
}

public void save (T object){
	 em.persist(object);
}

public T findOne(PK p){
	return em.find(entityClass, p);
}

public List<T> findAll() {
    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return em.createQuery(cq).getResultList();
}


}
