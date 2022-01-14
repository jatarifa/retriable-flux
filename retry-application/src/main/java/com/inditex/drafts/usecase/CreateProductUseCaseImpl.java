package com.inditex.drafts.usecase;

import com.inditex.drafts.domain.entity.Product;
import com.inditex.drafts.domain.repository.ProductRepository;
import com.inditex.drafts.domain.usecase.CreateProductUseCase;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

  private final Logger logger;

  private final ProductRepository productRepository;

  public CreateProductUseCaseImpl(final Logger logger, final ProductRepository productRepository) {
    this.logger = logger;
    this.productRepository = productRepository;
  }

  @Override
  public Mono<Product> createProduct(final Mono<Product> product) {
    return product.doOnNext(p -> logger.debug("Create product with name {}", p))
        .transform(productRepository::createProduct);
  }
}
