package com.inditex.drafts.domain.usecase;

import com.inditex.drafts.domain.entity.Product;
import reactor.core.publisher.Mono;

public interface CreateProductUseCase {

  Mono<Product> createProduct(Mono<Product> product);

}
