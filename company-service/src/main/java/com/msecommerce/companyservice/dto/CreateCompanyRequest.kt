package com.msecommerce.companyservice.dto

data class CreateCompanyRequest @JvmOverloads constructor(

    val companyName: String,
    val email: String,
    val webSite: String
)
