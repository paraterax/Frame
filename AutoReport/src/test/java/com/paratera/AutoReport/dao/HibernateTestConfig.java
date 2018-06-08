package com.paratera.AutoReport.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.paratera.comutil.Config;
import com.paratera.AutoReport.init.IgnoreScan;
import com.paratera.AutoReport.config.ModelConfig;

/*
 * This class is same as real HibernateConfiguration class in sources.
 * Only difference is that method dataSource & hibernateProperties 
 * implementations are specific to Hibernate working with H2 database.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(excludeFilters=@Filter(IgnoreScan.class), basePackages={  ModelConfig.SELF_ENTITY_PACKAGE, ModelConfig.SELF_DAO_PACKAGE  })
public class HibernateTestConfig {

    public HibernateTestConfig() throws IOException {
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream(new File("src/test/resources/AutoReportservice.properties"))) {
            p.load(fis);
            Config config = ModelConfig.getInstance().getConfig();
            for (Entry<Object, Object> entry : p.entrySet()) {
                config.setProp((String) entry.getKey(), entry.getValue());
            }
        }
    }
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { ModelConfig.SELF_ENTITY_PACKAGE });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;LOCK_TIMEOUT=10000");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource ds) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);
        return jdbcTemplate;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
