package com.mypack.springbootrestreactapp;


import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/***
 * 
 * @author Imran Khan
 *
 */
@Configuration
@EnableTransactionManagement
public class JndiConfig {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {

		/*
		 JndiDataSourceLookup lookup = new JndiDataSourceLookup();

         lookup.setResourceRef(true);

         DataSource dataSource = lookup.getDataSource("java:/jdbc/oracleDataSource");
         System.out.println("::::::::::::::::::: " + dataSource);
         return dataSource;

		 */
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();           // create JNDI data source
		bean.setJndiName("java:/jdbc/oracleDataSource");  // jndiDataSource is name of JNDI data source 
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}


	//@Bean(name = "domainEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IllegalArgumentException, NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.mypack.springbootrestreactapp" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		// properties.put("hibernate.default_schema","XXX");
		properties.put("hibernate.proc.param_null_passing", "true");
		em.setJpaPropertyMap(properties);
		return em;
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	//@Bean(name = "domainTransactionManager")
	public JpaTransactionManager getJpaTransactionManager() {
		return new JpaTransactionManager();

	}

	/*
	@Bean
   public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
      LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
      factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");

      return factoryBean;
   }

   @Bean
   public JpaTransactionManager geJpaTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
      return transactionManager;
   }
	 */

}
