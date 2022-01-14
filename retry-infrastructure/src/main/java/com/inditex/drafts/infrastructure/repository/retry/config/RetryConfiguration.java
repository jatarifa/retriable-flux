package com.inditex.drafts.infrastructure.repository.retry.config;

import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetryConfiguration {

  private BackoffConfiguration backoff;

  private List<String> ignoredExceptions = Collections.emptyList();
}
