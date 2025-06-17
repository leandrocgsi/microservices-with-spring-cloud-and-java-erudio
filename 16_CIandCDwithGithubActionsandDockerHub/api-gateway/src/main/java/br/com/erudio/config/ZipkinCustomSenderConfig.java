package br.com.erudio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.Sender;
import zipkin2.reporter.urlconnection.URLConnectionSender;

@Configuration
public class ZipkinCustomSenderConfig {

    @Value("${spring.zipkin.base-url:http://localhost:9411}")
    private String zipkinBaseUrl;

    @Bean
    public Sender zipkinSender() {
        String endpoint = zipkinBaseUrl + "/api/v2/spans";
        return URLConnectionSender.newBuilder()
            .endpoint(endpoint)
            .build();
    }

}