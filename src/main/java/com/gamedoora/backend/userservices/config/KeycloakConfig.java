package com.gamedoora.backend.userservices.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    private PropertiesConfig propertiesConfig;
    public Keycloak keycloak(){
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(getPropertiesConfig().getKeycloakServerUrl())
                .grantType(OAuth2Constants.PASSWORD)
                .realm(getPropertiesConfig().getKeycloakRealm())
                .clientId(getPropertiesConfig().getKeycloakClientId())
                .username(getPropertiesConfig().getKeycloakUserName())
                .password(getPropertiesConfig().getKeycloakPassword())
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10)
                                .disableTrustManager()
                                .build()
                ).build();
            return keycloak;
    }

    @Bean("usersResource")
    public UsersResource usersResource(){
        return keycloak().realm(getPropertiesConfig().getKeycloakRealm()).users();
    }

    public PropertiesConfig getPropertiesConfig() {
        return propertiesConfig;
    }
   @Autowired
    public void setPropertiesConfig(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
    }
}
