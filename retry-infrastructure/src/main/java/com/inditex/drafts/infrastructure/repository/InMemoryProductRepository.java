package com.inditex.drafts.infrastructure.repository;

import com.inditex.drafts.domain.entity.Product;
import com.inditex.drafts.domain.repository.ProductRepository;
import com.inditex.drafts.infrastructure.repository.retry.ConfigurableRetry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
@Slf4j
public class InMemoryProductRepository implements ProductRepository {

  private final ConfigurableRetry configurableRetry;

  private Product saveInMemoryProductEntity(Product product) {
    log.error("Trying to save: {}", product);
    int choice = RandomUtils.nextInt(1, 100);
    if (choice <= 10) {
      // 10% returns successfully
      log.error("Success");
      return product;
    } else if (choice <= 90) {
      // 80% throws retryable exception
      log.error("Throw error in DB exception");
      throw new RuntimeException("Error in DB");
    } else {
      // 10% throws non-retry exception
      log.error("Throw Duplicated exception");
      throw new DuplicateException();
    }
  }

  @Override
  public Mono<Product> createProduct(final Mono<Product> product) {
    return product.flatMap(p ->
        Mono.fromSupplier(() -> saveInMemoryProductEntity(p))
            .retryWhen(configurableRetry.build())
    );
  }
}
