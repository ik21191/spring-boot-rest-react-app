package com.mypack.spring.config;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.mypack.beans.ConditionalBean;
import com.mypack.beans.DatabaseTypeMongoCondition;
import com.mypack.beans.DatabaseTypeMysqlCondition;
import com.mypack.service.DatabaseTypeMongo;
import com.mypack.service.DatabaseTypeMysql;

@Configuration
@ComponentScan({
		"com.mypack.spring.boot.main",
		"com.mypack.entities",
		"com.mypack.spring.rest.controller",
		"com.mypack.spring.exception"})

@EnableJpaRepositories("com.mypack.spring.repository")
@EntityScan("com.mypack.entities")
public class AppConfig {
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	@Bean
	@Conditional(DatabaseTypeMysqlCondition.class)
	public DatabaseTypeMysql getMySqlDatabase() {
		log.info("getMySqlDatabase() called ......");
		return new DatabaseTypeMysql();
	}
	
	@Bean
	@Conditional(DatabaseTypeMongoCondition.class)
	public DatabaseTypeMongo getMongoDatabase() {
		log.info("getMongoDatabase() called ......");
		return new DatabaseTypeMongo();
	}
	
	@Bean
	@ConditionalOnProperty(name = "create.ConditionalBean", havingValue = "create", matchIfMissing = false)
	public ConditionalBean getConditionalBean() {
		log.info("getConditionalBean() called ......");
		return new ConditionalBean();
	}
	
	@Bean
	  @Autowired
	  public CommandLineRunner listAllBeans(ApplicationContext applicationContext) {
	      
	     return new CommandLineRunner() {
	        @Override
	        public void run(String... args) throws Exception {
	            RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
	            Map<RequestMappingInfo, HandlerMethod> handlerMethodMapping = mapping.getHandlerMethods();
	            handlerMethodMapping.forEach((k,v)->{
	                System.out.println(k);
	                System.out.println(v);
	                System.out.println("-----");
	            });
	        }
	     };
	  }
}
