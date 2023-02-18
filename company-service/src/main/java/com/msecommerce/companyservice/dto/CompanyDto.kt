package com.msecommerce.companyservice.dto

import com.msecommerce.companyservice.model.Company

data class CompanyDto @JvmOverloads constructor(

    val id: CompanyIdDto? = null,
    val companyName: String,
    val email: String,
    val webSite: String
) {

}
