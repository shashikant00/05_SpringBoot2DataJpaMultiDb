package in.nareshit.raghu.cofig.customer;

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
		entityManagerFactoryRef = "db2EntityManagerFactory",
		transactionManagerRef = "db2TransactionManager",
		basePackages = "in.nareshit.raghu.repo.customer")
public class DbTwoConfig {
	//data source
	
	//@Primary
	@Bean
	@ConfigurationProperties(prefix="db2.datasource")
	public DataSource db2DataSource() {
		return  DataSourceBuilder.create().build();
	}
	
	//Entity ManagerFactory
	//@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(
			EntityManagerFactoryBuilder emfb) {
		HashMap<String,Object> properties=new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(db2DataSource())
				.packages("in.nareshit.raghu.model.customer")
				.properties(properties)
				.build();
	}
	
	//TxManager
	
	//@Primary
	@Bean
	public PlatformTransactionManager db2TransactionManager(
			@Qualifier("db2EntityManagerFactory")
			EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}