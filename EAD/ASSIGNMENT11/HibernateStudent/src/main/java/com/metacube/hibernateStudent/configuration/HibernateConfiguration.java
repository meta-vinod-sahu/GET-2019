package com.metacube.hibernateStudent.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(getSessionFactory());
	}
    
	@Bean
	public SessionFactory getSessionFactory() {
		
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("com.metacube.hibernateStudent.model");
		bean.setHibernateProperties(getHibernateProperties());
		
		try {
			bean.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bean.getObject();
	}
	
	@Bean
	public HibernateTransactionManager hibTransMan() {
		return new HibernateTransactionManager(getSessionFactory());
	}
	
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/student");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		return basicDataSource;
		
	}

	@Bean
	public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dailact", "org.hibernate.dialect.MYSQL5Dailect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql","true");
        return properties;
        
	}

	

}
