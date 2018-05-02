package com.anexa.core.data.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.anexa.core.domain.IdentifiedDomainObject;

@NoRepositoryBean
public interface IdentifiedDomainObjectRepository<E extends IdentifiedDomainObject<ID>, ID extends Serializable> extends QueryRepository<E, ID>, JpaRepository<E, ID>  {

}
