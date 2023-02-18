package com.msecommerce.productservice.controller;

import com.msecommerce.productservice.dto.CreateProductRequest;
import com.msecommerce.productservice.dto.ProductDto;
import com.msecommerce.productservice.dto.ProductIdDto;
import com.msecommerce.productservice.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<ProductIdDto> getProductByBarcode(@PathVariable String barcode) {
        return ResponseEntity.ok(service.findProductByBarcode(barcode));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(service.findProductById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(service.createProduct(request));
    }
}
