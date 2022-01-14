package com.inditex.drafts.config;

import com.inditex.drafts.infrastructure.repository.retry.config.RetryConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The App configuration.
 */
@Configuration
public class AppConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "retry-configuration")
  @RefreshScope
  public RetryConfiguration retryConfiguration() {
    return new RetryConfiguration();
  }
}
