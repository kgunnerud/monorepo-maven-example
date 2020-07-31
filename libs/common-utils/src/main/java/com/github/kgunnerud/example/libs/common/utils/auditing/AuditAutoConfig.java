package com.github.kgunnerud.example.libs.common.utils.auditing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(RestTemplate.class)
@ConditionalOnProperty(name = "example.libs.utils.auditing.enabled")
public class AuditAutoConfig {

    @Bean // Could also use @ComponentScan
    AuditingService auditingService() {
        log.info("Auditing enabled");
        return new AuditingService();
    }
}
