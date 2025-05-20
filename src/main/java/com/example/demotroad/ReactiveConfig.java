package com.example.demotroad;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.security.GeneralSecurityException;
import java.time.Duration;
import javax.net.ssl.SSLException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ReactorClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import reactor.netty.http.client.HttpClient;

/**
 *
 * @author Kent Yeh
 */
@Log4j2
@Configuration
@Profile("reactive")
public class ReactiveConfig {

    @Bean(destroyMethod = "dispose")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public reactor.netty.resources.ConnectionProvider connectionProvider() {
        return reactor.netty.resources.ConnectionProvider.builder("Webapi")
                .maxConnections(10)//最大連線數
                .maxIdleTime(Duration.ofSeconds(20))
                .maxLifeTime(Duration.ofSeconds(60))
                .pendingAcquireTimeout(Duration.ofSeconds(60))
                .evictInBackground(Duration.ofSeconds(120))
                .build();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public HttpClient httpClient() {
        return HttpClient.create(connectionProvider())
                .followRedirect(true).headers(header
                -> header.add("User-Agent",
                        "Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/999.0"))
                .responseTimeout(Duration.ofSeconds(15))
                .secure(t -> {
                    try {
                        t.sslContext(SslContextBuilder
                                .forClient()
                                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                                .build());
                    } catch (SSLException ex) {
                        log.error(ex);
                    }
                });
    }

    @Bean(initMethod = "start",destroyMethod = "stop")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public ClientHttpRequestFactory clientHttpRequestFactory() throws GeneralSecurityException {
        return new ReactorClientHttpRequestFactory(httpClient());
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public RestTemplate restTemplate() throws GeneralSecurityException {
        return new RestTemplate(clientHttpRequestFactory());
    }
}
