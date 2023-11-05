//package com.example.Chapter6.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.ClientRegistrationService;
//import org.springframework.security.oauth2.provider.approval.DefaultUserApprovalHandler;
//import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpointHandlerMapping;
//import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableAuthorizationServer
//@EnableResourceServer
//public class OAuth2Config {
//    private final AuthenticationManager authenticationManager;
//    private final DataSource dataSource;
//    private final UserDetailsService userDetailsService;
//
//    public OAuth2Config(
//            AuthenticationManager authenticationManager,
//            DataSource dataSource,
//            UserDetailsService userDetailsService
//    ) {
//        this.authenticationManager = authenticationManager;
//        this.dataSource = dataSource;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Bean
//    public AccessTokenConverter accessTokenConverter() {
//        return new DefaultAccessTokenConverter();
//    }
//
//    @Bean
//    public ClientRegistrationService clientRegistrationService() {
//        return new JdbcClientRegistrationService(dataSource);
//    }
//
//    @Bean
//    public ClientDetailsService clientDetailsService() {
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//    @Bean
//    public FrameworkEndpointHandlerMapping oauth2EndpointHandlerMapping() {
//        return new FrameworkEndpointHandlerMapping();
//    }
//
//    @Bean
//    public AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer() {
//        AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();
//        endpoints.authenticationManager(authenticationManager)
//                .userApprovalHandler(new DefaultUserApprovalHandler())
//                .tokenStore(tokenStore())
//                .accessTokenConverter(accessTokenConverter())
//                .userDetailsService(userDetailsService);
//        return endpoints;
//    }
//
//    @Bean
//    public AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer() {
//        AuthorizationServerSecurityConfigurer security = new AuthorizationServerSecurityConfigurer();
//        security.checkTokenAccess("isAuthenticated()");
//        return security;
//    }
//
//    @Bean
//    public ClientDetailsServiceConfigurer clientDetailsServiceConfigurer() {
//        ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer();
//        clients.withClientDetails(clientDetailsService());
//        return clients;
//    }
//}
