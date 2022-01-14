package com.inditex.drafts.infrastructure.repository.retry;

import com.inditex.aqsw.framework.common.metrics.core.metric.MonMetrics;
import com.inditex.drafts.infrastructure.repository.retry.config.RetryConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.util.retry.Retry;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConfigurableRetry {

  private final RetryConfiguration config;

  public Retry build() {
    return Retry.backoff(config.getBackoff().getMaxAttempts(), config.getBackoff().getMinBackoff())
        .jitter(config.getBackoff().getJitter())
        .filter(e -> config.getIgnoredExceptions().stream().noneMatch(f -> e.getClass().getName().equals(f)))
        .onRetryExhaustedThrow(((retryBackoffSpec, retrySignal) -> {
          log.error("No more retries allowed");
          MonMetrics.counter("fail_on_retry").increment();
          return retrySignal.failure();
        }));
  }
}
