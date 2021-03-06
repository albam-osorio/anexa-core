package com.anexa.core.services.crud.impl;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.anexa.core.data.jpa.repository.QueryRepository;
import com.anexa.core.domain.IdentifiedDomainObject;
import com.anexa.core.services.crud.api.QueryService;

import lombok.val;

public abstract class QueryServiceImpl<E extends IdentifiedDomainObject<ID>, M extends IdentifiedDomainObject<ID>, ID extends Serializable>
		implements QueryService<M, ID> {

	public QueryServiceImpl() {
		super();
	}

	protected abstract QueryRepository<E, ID> getRepository();

	@Override
	public M findOneById(ID id) {
		E entity = findOneEntityById(id);

		val result = asModel(entity);
		return result;
	}

	@Override
	public Optional<M> findById(ID id) {
		Optional<E> optional = findEntityById(id);

		val result = asModel(optional);
		return result;
	}

	@Override
	public List<M> findAllById(Collection<ID> ids) {
		List<E> entities;

		if (ids.isEmpty()) {
			entities = new ArrayList<E>();
		} else {
			entities = getRepository().findAllById(ids);
		}

		val result = asModels(entities);
		return result;
	}

	protected E findOneEntityById(ID id) {
		val result = getRepository().findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("id = " + String.valueOf(id));
		}
		return result.get();
	}

	protected Optional<E> findEntityById(ID id) {
		val result = getRepository().findById(id);
		return result;
	}

	protected abstract M asModel(E entity);

	protected Optional<M> asModel(Optional<E> optional) {
		Optional<M> result;
		if (optional.isPresent()) {
			result = Optional.of(asModel(optional.get()));
		} else {
			result = Optional.empty();
		}
		return result;
	}

	protected List<M> asModels(Collection<E> entities) {
		val result = entities.stream().map(e -> asModel(e)).collect(toList());
		return result;
	}
}