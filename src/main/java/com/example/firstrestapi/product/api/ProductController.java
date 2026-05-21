package com.example.firstrestapi.product.api;

import com.example.firstrestapi.product.api.request.ProductRequest;
import com.example.firstrestapi.product.api.response.ProductResponse;
import com.example.firstrestapi.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody ProductRequest productRequest
    ) {

        ProductResponse productResponse =
                productService.create(productRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable Long id
    ) {

        ProductResponse productResponse =
                productService.findById(id);

        return ResponseEntity.ok(productResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest productRequest
    ) {

        ProductResponse productResponse =
                productService.update(id, productRequest);

        return ResponseEntity.ok(productResponse);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {

        List<ProductResponse> products =
                productService.findAll();

        return ResponseEntity.ok(products);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        productService.delete(id);
    }
}
