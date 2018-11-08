package kr.or.kosta.sjrent.common.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryCreator {
	
	SqlSessionFactory sqlSessionFactory;
	String configLocation;
	String environment;
	
	
	public SqlSessionFactory createSqlSessionFactory() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(configLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment);
		return sqlSessionFactory;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public String getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "SqlSessionFactoryCreator [sqlSessionFactory=" + sqlSessionFactory + ", configLocation=" + configLocation
				+ "]";
	}
}
