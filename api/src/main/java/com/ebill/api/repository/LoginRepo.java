package com.ebill.api.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ebill.api.model.CoLogin;

@Repository
public interface LoginRepo<T, ID extends Serializable>  extends GenericRepo<CoLogin, Long>{

}
 