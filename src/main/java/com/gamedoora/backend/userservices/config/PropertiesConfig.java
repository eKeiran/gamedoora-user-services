
package com.gamedoora.backend.userservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author aprajshekhar
 */
@Configuration
@RefreshScope

public class PropertiesConfig {

    private String primaryDbUrl;
    private String primaryDbDriver;
    private String primaryDbUser;
    private String primaryDbPassword;
    private String hibernateHbm2ddl;
    private String hibernateDialect;
    private String keycloakServerUrl;
    private String keycloakClientId;
    private String keycloakUserName;
    private String keycloakPassword;
    private String keycloakRealm;
    /**
     * @return the primaryDbUrl
     */
    public String getPrimaryDbUrl() {
        return primaryDbUrl;
    }

  /**
   * @param primaryDbUrl the primaryDbUrl to set
   */
  @Value("${db.primary.url}")
  public void setPrimaryDbUrl(String primaryDbUrl) {
        this.primaryDbUrl = primaryDbUrl;
    }

    /**
     * @return the primaryDbDriver
     */
    public String getPrimaryDbDriver() {
        return primaryDbDriver;
    }

    /**
     * @param primaryDbDriver the primaryDbDriver to set
     */
    @Value("${db.primary.driver}")
    public void setPrimaryDbDriver(String primaryDbDriver) {
        this.primaryDbDriver = primaryDbDriver;
    }

    /**
     * @return the primaryDbUser
     */
    public String getPrimaryDbUser() {
        return primaryDbUser;
    }

    /**
     * @param primaryDbUser the primaryDbUser to set
     */
    @Value("${db.primary.user}")
    public void setPrimaryDbUser(String primaryDbUser) {
        this.primaryDbUser = primaryDbUser;
    }

    /**
     * @return the primaryDbPassword
     */
    public String getPrimaryDbPassword() {
        return primaryDbPassword;
    }

    /**
     * @param primaryDbPassword the primaryDbPassword to set
     */
    @Value("${db.primary.password}")
    public void setPrimaryDbPassword(String primaryDbPassword) {
        this.primaryDbPassword = primaryDbPassword;
    }

  /**
   * @return the hibernateHbm2ddl
   */
  public String getHibernateHbm2ddl() {
    return hibernateHbm2ddl;
  }

  /**
   * @param hibernateHbm2ddl the hibernateHbm2ddl to set
   */
  @Value("${db.primary.hbm2ddl.auto}")
  public void setHibernateHbm2ddl(String hibernateHbm2ddl) {
    this.hibernateHbm2ddl = hibernateHbm2ddl;
  }

  /**
   * @return the hibernateDialect
   */
  public String getHibernateDialect() {
    return hibernateDialect;
  }

  /**
   * @param hibernateDialect the hibernateDialect to set
   */
  @Value("${db.primary.hibernate.dialect}")
  public void setHibernateDialect(String hibernateDialect) {
    this.hibernateDialect = hibernateDialect;
  }


    public String getKeycloakServerUrl() {
        return keycloakServerUrl;
    }
    @Value("${keycloak.server.url}")
    public void setKeycloakServerUrl(String keycloakServerUrl) {
        this.keycloakServerUrl = keycloakServerUrl;
    }

    public String getKeycloakUserName() {
        return keycloakUserName;
    }

    @Value("${keycloak.server.username}")
    public void setKeycloakUserName(String keycloakUserName) {
        this.keycloakUserName = keycloakUserName;
    }

    public String getKeycloakPassword() {
        return keycloakPassword;
    }
    @Value("${keycloak.server.password}")
    public void setKeycloakPassword(String keycloakPassword) {
        this.keycloakPassword = keycloakPassword;
    }

    public String getKeycloakRealm() {
        return keycloakRealm;
    }

    @Value("${userservice.keycloak.server.realm}")
    public void setKeycloakRealm(String keycloakRealm) {
        this.keycloakRealm = keycloakRealm;
    }

    public String getKeycloakClientId() {
        return keycloakClientId;
    }

    @Value("${keycloak.server.clientid}")
    public void setKeycloakClientId(String keycloakClientId) {
        this.keycloakClientId = keycloakClientId;
    }
}
