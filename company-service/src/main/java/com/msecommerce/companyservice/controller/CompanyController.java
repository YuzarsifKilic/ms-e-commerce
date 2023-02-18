package com.msecommerce.companyservice.controller;

import com.msecommerce.companyservice.dto.CompanyDto;
import com.msecommerce.companyservice.dto.CreateCompanyRequest;
import com.msecommerce.companyservice.dto.ProductIdDto;
import com.msecommerce.companyservice.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable String id) {
        return ResponseEntity.ok(service.getAllProductsInCompanyById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CreateCompanyRequest request) {
        return ResponseEntity.ok(service.createCompany(request));
    }

    @PutMapping("/add-product")
    public ResponseEntity<Void> addProductToCompany(@RequestBody ProductIdDto productIdDto) {
        service.addProductToCompany(productIdDto);
        return ResponseEntity.ok().build();
    }

}
