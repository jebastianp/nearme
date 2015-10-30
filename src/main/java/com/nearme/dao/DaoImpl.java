package com.nearme.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoImpl implements Dao {

	protected static Logger logger = LoggerFactory.getLogger(DaoImpl.class);
	@PersistenceContext(unitName = "nearme_schema")
	protected EntityManager em;
}
