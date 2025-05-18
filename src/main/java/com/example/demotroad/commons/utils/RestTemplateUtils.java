package com.example.demotroad.commons.utils;

import lombok.extern.log4j.Log4j2;

import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.core5.ssl.SSLContexts;

@Log4j2
public class RestTemplateUtils {

    public static RestTemplate getRestTemplate() {
        try {
            //本機測試時請自行調整為不進行憑證驗證
            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(
                    PoolingHttpClientConnectionManagerBuilder.create()
                            .setTlsSocketStrategy(
                                    new DefaultClientTlsStrategy(
                                            SSLContexts.custom()
                                                    .loadTrustMaterial(null, (chain, authType) -> true)
                                                    .build(),
                                            (host, session) -> true))
                            .build())
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);

            RestTemplate restTemplate = new RestTemplate(requestFactory);
            // 設定此物件將restTemplate回傳錯誤catch住
//            restTemplate.setErrorHandler(new RestTemplateException());

            return restTemplate;

        } catch (KeyStoreException | NoSuchAlgorithmException e) {
            log.error("Get SSL exception : {}", e.getMessage());
            return new RestTemplate();
        } catch (KeyManagementException e) {
            log.error("KeyManagementException : {}", e.getMessage());
            return new RestTemplate();
        }
    }
}
