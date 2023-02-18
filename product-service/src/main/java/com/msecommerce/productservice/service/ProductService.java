package com.msecommerce.productservice.service;

import com.msecommerce.productservice.client.CompanyServiceClient;
import com.msecommerce.productservice.dto.CreateProductRequest;
import com.msecommerce.productservice.dto.ProductDto;
import com.msecommerce.productservice.dto.ProductIdDto;
import com.msecommerce.productservice.exception.CompanyNotyFoundException;
import com.msecommerce.productservice.exception.ProductNotFoundException;
import com.msecommerce.productservice.model.Product;
import com.msecommerce.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CompanyServiceClient companyServiceClient;

    public ProductService(ProductRepository repository, CompanyServiceClient companyServiceClient) {
        this.repository = repository;
        this.companyServiceClient = companyServiceClient;
    }

    public List<ProductDto> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }

    public ProductIdDto findProductByBarcode(String barcode) {
        return repository.findByBarcode(barcode)
                .map(product -> new ProductIdDto(product.getId(), product.getBarcode()))
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not found by barcode : " + barcode));
    }

    public ProductDto findProductById(String id) {
        return repository.findById(id)
                .map(ProductDto::convert)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not found by id : " + id));
    }

    public ProductDto createProduct(CreateProductRequest request) {

        companyServiceClient.getCompanyById(request.getCompanyId());
        Product product = new Product(request.getProductName(),
                    request.getQuantity(),
                    request.getPrice(),
                    false,
                    request.getBarcode());
        Product savedProduct = repository.save(product);

        ProductIdDto productIdDto = new ProductIdDto(savedProduct.getId(), savedProduct.getBarcode(), request.getCompanyId());
        companyServiceClient.addProductToCompany(productIdDto);
        return ProductDto.convert(savedProduct);
    }
}
