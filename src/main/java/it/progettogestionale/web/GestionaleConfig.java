package it.progettogestionale.web;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages ="it.progettogestionale.web.controller" )
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.progettogestionale.repository", entityManagerFactoryRef = "ref",transactionManagerRef = "tmf")
public class GestionaleConfig {
	
	//----------------------------------view, che non serve------------------------------------
	
	@Bean
	public FreeMarkerViewResolver configureResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		return resolver;
	}
	
	@Bean
	public  FreeMarkerConfigurer configurerFreeMarker() {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		config.setTemplateLoaderPath("/WEB-INF/view/");
		return config;
	}
	
	//----------------------------------------------connection db-----------------------------

	@Bean
	public DataSource getDbConnection() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver ");
		ds.setUsername("postgres");
		ds.setPassword("root");
		ds.setUrl("jdbc:postgresql://localhost:5432/gestionale");
		
		return ds;
	}
	
	@Bean(name="ref") //configurazione hibernate
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(getDbConnection());
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		return factory;
	}
	
	@Bean(name="tmf") //
	public PlatformTransactionManager getTransactionManager() {
		JpaTransactionManager jtm = new JpaTransactionManager(getEntityManager().getObject());
		//jtm.setEntityManagerFactory(getEntityManager().getObject());
		return jtm;
	}
}
