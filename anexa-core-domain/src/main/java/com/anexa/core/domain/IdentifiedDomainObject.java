package com.anexa.core.domain;

import java.io.Serializable;

public interface IdentifiedDomainObject<ID extends Serializable> extends Serializable {

	ID getId();
}
