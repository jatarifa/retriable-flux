package com.inditex.drafts.apirest.controller;

import com.inditex.drafts.domain.entity.Product;
import com.inditex.drafts.domain.usecase.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProductApiController {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @GetMapping("/v1/product")
  public Mono<ResponseEntity<Product>> createProduct() {
    Product product = new Product();
    product.setId("1");
    product.setPrice(1.1);
    product.setDiscount(11);

    return createProductUseCase.createProduct(Mono.just(product)).map(ResponseEntity::ok);
  }
}
