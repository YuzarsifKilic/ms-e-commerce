package com.msecommerce.productservice.repository;

import com.msecommerce.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByBarcode(String barcode);
}
