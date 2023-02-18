package com.msecommerce.companyservice.client;

import com.msecommerce.companyservice.dto.ProductDto;
import com.msecommerce.companyservice.dto.ProductIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "product-service", path = "/v1/product")
public interface ProductServiceClient {

    @GetMapping("/getall")
    ResponseEntity<List<ProductDto>> getAllProducts();

    @GetMapping("/barcode/{barcode}")
    ResponseEntity<ProductIdDto> getProductByBarcode(@PathVariable(value = "barcode") String barcode);

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable(value = "id") String id);

}
