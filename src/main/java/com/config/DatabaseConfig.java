package com.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(value = "com.repository.*")
@EnableTransactionManagement
@ComponentScan(value = "com.*")
@PropertySource(value = "classpath:db.properties")
public class DatabaseConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));

        dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty("db.initialSize")));
        dataSource.setMinIdle(Integer.parseInt(env.getRequiredProperty("db.minIdle")));
        dataSource.setMaxIdle(Integer.parseInt(env.getRequiredProperty("db.maxIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(
                Long.parseLong(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(
                Long.parseLong(env.getRequiredProperty("db.minEvictableIdleTimeMillis")));
        dataSource.setTestOnBorrow(
                Boolean.parseBoolean(env.getRequiredProperty("db.testOnBorrow")));
        dataSource.setValidationQuery(env.getRequiredProperty("db.validationQuery"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager manager= new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }

    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().
                getResourceAsStream("hibernate.properties");
        try {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("--");
        }
    }
}
