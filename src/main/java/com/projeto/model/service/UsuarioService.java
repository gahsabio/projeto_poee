package com.projeto.model.service;

import javax.persistence.EntityTransaction;

import com.projeto.model.dao.UsuarioDao;
import com.projeto.model.models.Usuario;
import com.projeto.struct.util.ProjectVariables;

public class UsuarioService extends ConexaoBancoService {

	private UsuarioDao usuarioDao;

	public UsuarioService() {
		this.usuarioDao = new UsuarioDao(this.getEntityManager());
	}

	public Integer save(Usuario usuario) {
		
		Integer toReturn = 0;

		EntityTransaction trx = this.getEntityManager().getTransaction();

		if (validarDigitacao(usuario) == ProjectVariables.DIGITACAO_OK) {

			try {
				trx.begin();
				this.getUsuarioDao().save(usuario);
				trx.commit();

			} catch (Exception e) {
				e.printStackTrace();

				if (trx.isActive()) {
					trx.rollback();
				}
				toReturn = ProjectVariables.ERRO_INCLUSAO;
			} finally {
				this.close();
			}
		} else {
			toReturn = ProjectVariables.CAMPO_VAZIO;
		}
		
		return toReturn;
	}
	
public Integer update(Usuario usuario) {
		
		Integer toReturn = 0;

		EntityTransaction trx = this.getEntityManager().getTransaction();

		if (validarDigitacao(usuario) == ProjectVariables.DIGITACAO_OK) {

			try {
				trx.begin();
				this.getUsuarioDao().update(usuario);
				trx.commit();

			} catch (Exception e) {
				e.printStackTrace();

				if (trx.isActive()) {
					trx.rollback();
				}
				toReturn = ProjectVariables.ERRO_ALTERACAO;
			} finally {
				this.close();
			}
		} else {
			toReturn = ProjectVariables.CAMPO_VAZIO;
		}
		
		return toReturn;
	}

	public Usuario findById(Integer id) {
		return this.getUsuarioDao().findById(id);
	}

	public Integer validarDigitacao(Usuario usuario) {
		if (ProjectVariables.digitacaoCampo(usuario.getUsername())) {
			return ProjectVariables.CAMPO_VAZIO;
		}

		return ProjectVariables.DIGITACAO_OK;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

}
