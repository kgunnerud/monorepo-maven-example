package com.github.kgunnerud.example.libs.common.utils.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration(proxyBeanMethods = false)
public class PropertiesAutoConfig {

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnProperty(value = "example.utils.common.app.load-properties", matchIfMissing = true)
    @PropertySource(value = "common-app.yaml", factory = YamlPropertySourceFactory.class)
    public static class CommonAppConfig {

    }

    // Just an example of how you can add loads of default properties just when certain conditions are met (e.g. KafkaTemplate is a bean=
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnBean(KafkaTemplate.class)
    @ConditionalOnProperty(value = "example.utils.common.kafka.load-properties")
    @PropertySource(value = "common-kafka.yaml", factory = YamlPropertySourceFactory.class)
    @PropertySource(value = "common-kafka-topics.yaml", factory = YamlPropertySourceFactory.class)
    public static class CommonKafkaConfig {

    }
}
