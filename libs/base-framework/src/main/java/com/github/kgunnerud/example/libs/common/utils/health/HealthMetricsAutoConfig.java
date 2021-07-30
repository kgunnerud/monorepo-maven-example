package com.github.kgunnerud.example.libs.common.utils.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration;
import org.springframework.boot.actuate.health.HealthContributorRegistry;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(HealthContributorRegistry.class)
@AutoConfigureAfter(HealthContributorAutoConfiguration.class)
public class HealthMetricsAutoConfig {

    @Bean
    static HealthToMeterBinder healthToMeterBinder(HealthContributorRegistry registry) {
        log.info("Health to Metrics enabled"); // Just so you can see it in the logs, decide yourself if stuff like this is needed....
        return new HealthToMeterBinder(registry);
    }
}
