package edu.bsu.schedule.databasemodule.config;


import oracle.jdbc.pool.OracleDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:config/databaseConfig.properties","classpath:config/hibernateConfig.properties"})
@ComponentScan(basePackages={"edu.bsu.schedule.dao.impl.hibernate","edu.bsu.schedule.service.impl"})
public class ApplicationConfig {
    private final static Logger logger = LogManager.getLogger(ApplicationConfig.class);
    @Autowired
    private Environment env;

    @Bean
    public DataSource restDataSource() {
        OracleDataSource dataSource = null;
        try {
            dataSource = new OracleDataSource();
        } catch (SQLException e) {
            logger.error(e);
        }

        dataSource.setURL(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql","true");
            }
        };
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "edu.bsu.schedule.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
