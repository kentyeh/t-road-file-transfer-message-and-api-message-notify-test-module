package com.example.demotroad;

import java.security.GeneralSecurityException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.core5.ssl.SSLContexts;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Kent Yeh
 */
@Configuration
@Profile("default")
public class AppConfig {

    @Bean(destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public HttpClientConnectionManager httpClientConnectionManager() throws GeneralSecurityException {
        return PoolingHttpClientConnectionManagerBuilder.create()
                .setTlsSocketStrategy(
                        new DefaultClientTlsStrategy(
                                SSLContexts.custom()
                                        .loadTrustMaterial(null, (chain, authType) -> true)
                                        .build(),
                                (host, session) -> true))
                .build();
    }

    @Bean(destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public HttpClient httpClient() throws GeneralSecurityException {
        return HttpClients.custom().setConnectionManager(httpClientConnectionManager()).build();
    }

    @Bean(destroyMethod = "destroy")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public ClientHttpRequestFactory clientHttpRequestFactory() throws GeneralSecurityException {
        HttpComponentsClientHttpRequestFactory hcchrf = new HttpComponentsClientHttpRequestFactory();
        hcchrf.setHttpClient(httpClient());
        return hcchrf;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public RestTemplate restTemplate() throws GeneralSecurityException {
        return new RestTemplate(clientHttpRequestFactory());
    }
}
