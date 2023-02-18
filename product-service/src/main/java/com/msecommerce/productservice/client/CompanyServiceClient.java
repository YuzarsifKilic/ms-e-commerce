package com.msecommerce.productservice.client;

import com.msecommerce.productservice.dto.CompanyDto;
import com.msecommerce.productservice.dto.ProductIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "company-service", path = "/v1/company")
public interface CompanyServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getCompanyById(@PathVariable String id);

    @PutMapping("/add-product")
    ResponseEntity<Void> addProductToCompany(@RequestBody ProductIdDto productIdDto);
}
