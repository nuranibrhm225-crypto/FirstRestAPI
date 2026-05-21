package com.example.firstrestapi.product.service;

import com.example.firstrestapi.product.api.request.ProductRequest;
import com.example.firstrestapi.product.api.response.ProductResponse;
import com.example.firstrestapi.product.domain.Product;
import com.example.firstrestapi.product.repository.ProductRepository;
import com.example.firstrestapi.product.support.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.firstrestapi.product.support.exception.ProductNotFoundException;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {

        Product product = productMapper.toProduct(productRequest);

        Product savedProduct = productRepository.save(product);

        return productMapper.toProductResponse(savedProduct);
    }
    public ProductResponse findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return productMapper.toProductResponse(product);
    }
    public ProductResponse update(Long id, ProductRequest productRequest) {

        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        product.setName(productRequest.getName());

        Product updatedProduct = productRepository.save(product);

        return productMapper.toProductResponse(updatedProduct);
    }
    public List<ProductResponse> findAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
    public void delete(Long id) {

        productRepository.deleteById(id);
    }
}
