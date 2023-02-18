package com.msecommerce.companyservice.repository;

import com.msecommerce.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
