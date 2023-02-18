package com.msecommerce.companyservice.dto

data class CompanyIdDto @JvmOverloads constructor(

    val id: String? = "",
    val productList: List<ProductDto>? = ArrayList()
) {

}
