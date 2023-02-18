package com.msecommerce.productservice.dto


data class CompanyDto @JvmOverloads constructor(

    val id: CompanyIdDto? = null,
    val companyName: String,
    val email: String,
    val webSite: String
) {

}
