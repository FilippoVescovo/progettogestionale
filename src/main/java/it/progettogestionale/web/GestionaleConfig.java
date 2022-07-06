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

import it.progettogestionale.web.dao.AppOwnerDao;
import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.dao.LogFileAppDao;
import it.progettogestionale.web.dao.LogFileRescanDao;
import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.dao.impl.AppOwnerDaoImpl;
import it.progettogestionale.web.dao.impl.ApplicazioneDaoImpl;
import it.progettogestionale.web.dao.impl.LogFileAppDaoImpl;
import it.progettogestionale.web.dao.impl.LogFileRescanDaoImpl;
import it.progettogestionale.web.dao.impl.RescanDaoImpl;
import it.progettogestionale.web.dao.impl.UtenteDaoImpl;



@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "it.progettogestionale.web.rest")
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
		ds.setDriverClassName("org.postgresql.Driver");
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
	
	//--------------------------------------------BEAN-----------------------------------------------
	@Bean
	public ApplicazioneDao getAppService() {
		return new ApplicazioneDaoImpl();
	}
	
	@Bean
	public AppOwnerDao getAppOwnerService() {
		return new AppOwnerDaoImpl();
	}
	
	@Bean
	public LogFileAppDao getLogFileAppService() {
		return new LogFileAppDaoImpl();
	}
	
	@Bean
	public LogFileRescanDao getLogFileRescanService() {
		return new LogFileRescanDaoImpl();
	}
	
	@Bean
	public RescanDao getRescanService() {
		return new RescanDaoImpl();
	}
	
	@Bean
	public UtenteDao getUtenteService() {
		return new UtenteDaoImpl();
	}
	
}
