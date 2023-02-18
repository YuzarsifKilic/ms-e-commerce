package com.msecommerce.companyservice.dto


data class ProductDto @JvmOverloads constructor(

    val id: ProductIdDto? = null,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val isSold: Boolean
) {

}
