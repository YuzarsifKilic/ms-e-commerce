package com.msecommerce.companyservice.dto

data class ProductIdDto @JvmOverloads constructor(

    val id: String ? = "",
    val barcode: String,
    val companyId: String? = ""
) {

    companion object {
        @JvmStatic
        fun convert(id: String, barcode: String, companyId: String?): ProductIdDto {
            return ProductIdDto(id, barcode, companyId);
        }
    }
}