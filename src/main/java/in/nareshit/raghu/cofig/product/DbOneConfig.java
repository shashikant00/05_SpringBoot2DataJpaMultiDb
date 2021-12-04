package in.nareshit.raghu.cofig.product;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "db1EntityManagerFactory",
		transactionManagerRef = "db1TransactionManager",
		basePackages = "in.nareshit.raghu.repo.product")
public class DbOneConfig {

	//data source
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix="db1.datasource")
	public DataSource db1DataSource() {
		return  DataSourceBuilder.create().build();
	}
	
	//Entity ManagerFactory
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(
			EntityManagerFactoryBuilder emfb) {
		HashMap<String,Object> properties=new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(db1DataSource())
				.packages("in.nareshit.raghu.model.product")
				.properties(properties)
				.build();
	}
	
	//TxManager
	
	@Primary
	@Bean
	public PlatformTransactionManager db1TransactionManager(
			@Qualifier("db1EntityManagerFactory")
			EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
