package com.anexa.core.data.jpa.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.anexa.core.domain.IdentifiedDomainObject;

@NoRepositoryBean
public interface QueryRepository<T extends IdentifiedDomainObject<ID>, ID extends Serializable>
		extends Repository<T, ID> {

	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAllById(Iterable<ID> ids);

	T getOne(ID id);

	Optional<T> findById(ID id);

	boolean existsById(ID id);
}
