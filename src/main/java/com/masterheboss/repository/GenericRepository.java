package com.masterheboss.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;

import com.masterheboss.globaleinterface.Identifiable;



public abstract class GenericRepository<T extends Identifiable<PK>, PK> {

  @PersistenceUnit(unitName = "HibernateProject")
  private EntityManagerFactory entityManagerFactory;

  @PersistenceContext
  EntityManager em;

  private Class<T> entityClass;

  public GenericRepository(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public void save(T object) {
    em.persist(object);
  }

  public T findOne(PK p) {
    return em.find(entityClass, p);
  }

  public List<T> findAll() {
    EntityManagerFactory Factory = Persistence.createEntityManagerFactory("HibernateProject");
    EntityManager e=  Factory.createEntityManager();
    //entityManagerFactory.createEntityManager();
    //CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
    CriteriaQuery cq = e.getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    //return em.createQuery(cq).getResultList();
    return e.createQuery(cq).getResultList();
  }


}
