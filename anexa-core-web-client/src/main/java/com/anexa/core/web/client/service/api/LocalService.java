package com.anexa.core.web.client.service.api;

import java.io.Serializable;
import java.util.List;

import com.anexa.core.domain.IdentifiedDomainObject;

public interface LocalService<M extends IdentifiedDomainObject<ID>, ID extends Serializable> {

	List<M> findAll();

	M get(ID id);

	List<M> getAllByIdIn(List<ID> ids);

	M create(M model);

	M update(M model);

	void delete(ID id, int version);
}