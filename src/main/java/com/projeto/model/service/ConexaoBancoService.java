package com.projeto.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto.struct.persistence.ConexaoBancoDados;
import com.projeto.struct.util.ProjectVariables;

public abstract class ConexaoBancoService {
	
	@PersistenceContext(unitName = ProjectVariables.PERSISTENCE_UNIT_NAME)
	private final EntityManager entityManager;
	
	public ConexaoBancoService() {
		this.entityManager = ConexaoBancoDados.getConexaoBancoDados().getEntityManager();
	}
	
	public void close() {
		if(this.getEntityManager().isOpen()) {
			this.getEntityManager().close();
		}
		
	}
	
//	public EntityTransaction getTransaction() {
//		return this.getEntityManager().getTransaction();
//	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
