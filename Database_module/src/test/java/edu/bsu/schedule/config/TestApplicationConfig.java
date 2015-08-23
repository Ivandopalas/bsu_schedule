package edu.bsu.schedule.config;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@EnableTransactionManagement
@PropertySource({"classpath:testDatabaseConfig.properties","classpath:config/hibernateConfig.properties"})
@ImportResource({"classpath:/dbUnitConfig.xml"})
@ComponentScan(basePackages={"edu.bsu.schedule.dao.impl.hibernate"})
public class TestApplicationConfig {
    private final static Logger logger = LogManager.getLogger(TestApplicationConfig.class);
    @Autowired
    private Environment env;

    @Bean(name="dataSource")
    public DataSource restDataSource() {
        OracleDataSource dataSource = null;
        try {
            dataSource = new OracleDataSource();
            dataSource.setConnectionProperties(new Properties(){
                {
                    setProperty("schema","TEST");
                }
            });
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
   /* @Bean
    @Autowired
    public DatabaseDataSourceConnectionFactoryBean DataSourceConnectionFactoryBean(DatabaseConfigBean config){
        DatabaseDataSourceConnectionFactoryBean ddscfb = new DatabaseDataSourceConnectionFactoryBean();
        ddscfb.setDataSource(restDataSource());
        ddscfb.setDatabaseConfig(config);
        ddscfb.setSchema("TEST");

        return ddscfb;
    }
    @Bean
    public OracleDataTypeFactory oracleDataTypeFactory(){
        return new OracleDataTypeFactory();
    }
    @Bean
    @Autowired
    public DatabaseConfigBean databaseConfigBean(OracleDataTypeFactory factory){
        DatabaseConfigBean databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setDatatypeFactory(factory);
        databaseConfigBean.setSkipOracleRecyclebinTables(true);
        return databaseConfigBean;
    }*/
}
