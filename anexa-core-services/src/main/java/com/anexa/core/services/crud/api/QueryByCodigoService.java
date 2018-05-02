package com.anexa.core.services.crud.api;

import java.io.Serializable;

import com.anexa.core.domain.ObjectWithCode;

public interface QueryByCodigoService<M extends ObjectWithCode<ID>, ID extends Serializable> {

	M findOneByCodigo(String codigo);

}