package com.msecommerce.productservice.dto

data class CompanyIdDto @JvmOverloads constructor(

    val id: String? = "",
    val productList: List<ProductDto>? = ArrayList()
) {

}
