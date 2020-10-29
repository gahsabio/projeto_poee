package com.projeto.struct.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.struct.util.ProjectVariables;

public class ConexaoBancoDados {

	private static ConexaoBancoDados CONEXAO_BANCO_DADOS;
	private static EntityManagerFactory CONEXAO_FACTORY;

	private ConexaoBancoDados() {

		if (CONEXAO_FACTORY == null) {
			CONEXAO_FACTORY = getCreateConexaoFactory();
		}

	}

	public static ConexaoBancoDados getConexaoBancoDados() {

		if (CONEXAO_BANCO_DADOS == null) {
			CONEXAO_BANCO_DADOS = new ConexaoBancoDados();
		}

		return CONEXAO_BANCO_DADOS;
	}
	
	public EntityManager getEntityManager() {
		return CONEXAO_FACTORY.createEntityManager();
	}

	private EntityManagerFactory getCreateConexaoFactory() {

		Map<String, String> properties = new HashMap<String, String>();

		properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/indicadores?createDatabaseIfNotExist=true&useSSL=false");
		properties.put("hibernate.connection.username", "root");
		//properties.put("hibernate.connection.password", "root");
		properties.put("hibernate.c3p0.min_size", "10");
		properties.put("hibernate.c3p0.max_size", "20");
		properties.put("hibernate.c3p0.acquire_increment", "1");
		properties.put("hibernate.c3p0.idle_test_period", "3000");
		properties.put("hibernate.c3p0.max_statements", "50");
		properties.put("hibernate.c3p0.timeout", "1800");		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("useUnicode", "true");
		properties.put("characterEncoding", "UTF-8");
		properties.put("hibernate.default_schema", "projeto");

		return Persistence.createEntityManagerFactory(ProjectVariables.PERSISTENCE_UNIT_NAME, properties);
	}

}
