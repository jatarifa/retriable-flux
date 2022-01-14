package com.inditex.drafts.domain.repository;

import com.inditex.drafts.domain.entity.Product;
import reactor.core.publisher.Mono;

public interface ProductRepository {

  Mono<Product> createProduct(final Mono<Product> product);

}
