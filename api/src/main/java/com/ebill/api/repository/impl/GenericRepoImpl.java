package com.ebill.api.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ebill.api.repository.GenericRepo;

@NoRepositoryBean
public class GenericRepoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements GenericRepo<T, ID>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final EntityManager em;

	private final JpaEntityInformation jpaEntityInformation;
	


	public GenericRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);

		this.em = em; 
		this.jpaEntityInformation= entityInformation;

	}
	
	  /*public GenericRepoImpl(Class<T> domainClass, EntityManager em) {
	        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em, null); 
	    }*/
	
	  
	  private  Class<?> springDataRepositoryInterface;
	  public Class<?> getSpringDataRepositoryInterface() {
	   return springDataRepositoryInterface;
	  }

	@Override
	public <S extends T> S save(S entity) {
		return super.save(entity);
	}

	@Override
	public List<T> search(CriteriaQuery<T> criteriaQuery, Map<String, Object> parameterMap, Integer fromIndex,
			Integer neededCount) {

		TypedQuery<T> query = em.createQuery(criteriaQuery);

		if (parameterMap != null) {
			for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		if (fromIndex != null) {
			query.setFirstResult(fromIndex);
		}

		if (neededCount != null) {
			query.setMaxResults(neededCount);
		}

		List<T> returnList = query.getResultList();
		return returnList;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	@Override
	public long getCount(CriteriaQuery<T> criteriaQuery, Map<String, Object> parameterMap) {

		TypedQuery<T> query = em.createQuery(criteriaQuery);

		if (parameterMap != null) {
			for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return (Long) query.getSingleResult();
	}

	@Override
	public T findOne(ID id) {
		T result = null;
		result = super.getById(id);
		return result;
	}

}
