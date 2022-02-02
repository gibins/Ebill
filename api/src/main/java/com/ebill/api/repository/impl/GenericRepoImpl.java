package com.ebill.api.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.ebill.api.repository.GenericRepo;

public class GenericRepoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements GenericRepo<T, ID> {

	private final EntityManager em;

	public GenericRepoImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);

		this.em = em;

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
