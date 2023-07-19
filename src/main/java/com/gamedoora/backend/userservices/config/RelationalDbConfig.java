package com.gamedoora.backend.userservices.config;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * @author aprajshekhar
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.gamedoora.backend.userservices.repository",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager")
public class RelationalDbConfig {
  private PropertiesConfig propertiesConfig;
   
   @Primary
   @Bean(name="primaryDs")
    public DataSource primaryDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(getPropertiesConfig().getPrimaryDbDriver());
        dataSourceBuilder.url(getPropertiesConfig().getPrimaryDbUrl());
        dataSourceBuilder.username(getPropertiesConfig().getPrimaryDbUser());
        dataSourceBuilder.password(getPropertiesConfig().getPrimaryDbPassword());
        
        return dataSourceBuilder.build();
    }
    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("primaryDs") DataSource primaryDataSource, EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(primaryDataSource)
        .properties(Maps.fromProperties(additionalProperties()))
        .packages("com.gamedoora.model.dao")
        .persistenceUnit("primaryPersistenceUnit")
        .build();
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
    
    Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", getPropertiesConfig().getHibernateHbm2ddl());
    properties.setProperty(
            "hibernate.dialect", getPropertiesConfig().getHibernateDialect());

    return properties;
}
    
  /**
   * @return the propertiesConfig
   */
  public PropertiesConfig getPropertiesConfig() {
    return propertiesConfig;
  }

  /**
   * @param propertiesConfig the propertiesConfig to set
   */
  @Autowired
  public void setPropertiesConfig(PropertiesConfig propertiesConfig) {
    this.propertiesConfig = propertiesConfig;
  }
}
