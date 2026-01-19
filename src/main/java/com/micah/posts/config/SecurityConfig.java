package com.micah.posts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

import com.micah.posts.filters.UserProvisioningFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserProvisioningFilter userProvisioningFilter,
            JwtAuthenticationConverter jwtAuthenticationConverter) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize.requestMatchers("/h2-console/**").permitAll().anyRequest().authenticated())
                .csrf(csrf -> csrf.disable()).headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)))
                .addFilterAfter(userProvisioningFilter, BearerTokenAuthenticationFilter.class);

        return http.build();

    }

    // @Bean
    // public JwtAuthenticationConverter jwtConverter() {
    // JwtGrantedAuthoritiesConverter authoritiesConverter = new
    // JwtGrantedAuthoritiesConverter();
    // authoritiesConverter.setAuthoritiesClaimName("realm_access.roles"); //
    // Keycloak roles
    // authoritiesConverter.setAuthorityPrefix("ROLE_");

    // return new JwtAuthenticationConverter() {
    // @Override
    // protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
    // return authoritiesConverter.convert(jwt);
    // }
    // };
    // }

}
