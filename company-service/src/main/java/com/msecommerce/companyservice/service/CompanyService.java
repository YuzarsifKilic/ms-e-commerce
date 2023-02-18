package com.msecommerce.companyservice.service;

import com.msecommerce.companyservice.client.ProductServiceClient;
import com.msecommerce.companyservice.dto.*;
import com.msecommerce.companyservice.exception.CompanyNotyFoundException;
import com.msecommerce.companyservice.model.Company;
import com.msecommerce.companyservice.repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final ProductServiceClient productServiceClient;

    public CompanyService(CompanyRepository repository, ProductServiceClient productServiceClient) {
        this.repository = repository;
        this.productServiceClient = productServiceClient;
    }

    public CompanyDto getAllProductsInCompanyById(String id) {
        Company company = findById(id);

        CompanyDto companyDto = new CompanyDto(new CompanyIdDto(company.getId(),
                company.getProductList()
                        .stream()
                        .map(productServiceClient::getProductById)
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList())),
                company.getCompanyName(),
                company.getEmail(),
                company.getWebSite());

        return companyDto;
    }

    protected Company findById(String id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new CompanyNotyFoundException("Company could not found by id : " + id));
    }

    public CompanyDto createCompany(CreateCompanyRequest request) {
        Company company = new Company(request.getCompanyName(), request.getEmail(), request.getWebSite());

        Company savedCompany = repository.save(company);

        CompanyDto companyDto = new CompanyDto(new CompanyIdDto(savedCompany.getId()),
                savedCompany.getCompanyName(),
                savedCompany.getEmail(),
                savedCompany.getWebSite());

        return companyDto;
    }

    public void addProductToCompany(ProductIdDto productIdDto) {
        String productId = productServiceClient.getProductByBarcode(productIdDto.getBarcode()).getBody().getId();

        Company company = findById(productIdDto.getCompanyId());

        company.getProductList()
                .add(productId);
    }

}
