package com.ebill.api.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * @NoRepositoryBean
 * https://stackoverflow.com/questions/11576831/understanding-the-spring-data-jpa-norepositorybean-interface
 */

@NoRepositoryBean
@EnableJpaRepositories 
public interface GenericRepo <T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	
	/**
	 * Search List of entity values.
	 * @param criteriaQuery
	 * @param parameterMap
	 * @return
	 */
	List<T> search(CriteriaQuery<T> criteriaQuery, Map<String, Object> parameterMap, Integer fromIndex, Integer neededCount);
	
	/**
	 * Return criteriaBuilder instance.
	 * @return
	 */
	CriteriaBuilder getCriteriaBuilder();
	
	/**
	 * Get count of entity.
	 * @param criteriaQuery
	 * @param parameterMap
	 * @return
	 */
	long getCount(CriteriaQuery<T> criteriaQuery, Map<String, Object> parameterMap);
	
	/**
	 * Find entity based on primary key.
	 * @param id
	 * @param errorNotFound
	 * @return
	 */
	T findOne(ID id);
}


