package com.inditex.drafts.infrastructure.repository.retry.config;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackoffConfiguration {

  private static long DEFAULT_MAX_ATTEMPTS = 3;

  private static Duration DEFAULT_MIN_BACKOFF = Duration.ofSeconds(2);

  private static double DEFAULT_JITTER = 0;

  private long maxAttempts = DEFAULT_MAX_ATTEMPTS;

  private Duration minBackoff = DEFAULT_MIN_BACKOFF;

  private double jitter = DEFAULT_JITTER;
}
