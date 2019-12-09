package com.flying.model.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db-cfg-instant.properties")
public class ModelConfig {
}
