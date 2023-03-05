package com.datmt.keycloak.springbootauth.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Separate this to avoid cyclic dependency
 */
@Configuration
@ConditionalOnProperty(name = "security.config.use-keycloak", havingValue = "true", matchIfMissing = true)
public class KeycloakResolverConfig {

    @Bean
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
