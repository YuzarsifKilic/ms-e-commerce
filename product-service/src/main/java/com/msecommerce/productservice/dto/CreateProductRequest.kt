package com.msecommerce.productservice.dto

data class CreateProductRequest @JvmOverloads constructor(

    val companyId: String,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val barcode: String
)
