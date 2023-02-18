package com.msecommerce.productservice.dto

import com.msecommerce.productservice.model.Product

data class ProductDto @JvmOverloads constructor(

    val id: ProductIdDto? = null,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val isSold: Boolean
) {
    companion object {
        @JvmStatic
        fun convert(from: Product) : ProductDto {
            return ProductDto(
                from.id?.let { ProductIdDto.convert(it, from.barcode, null) },
                from.productName,
                from.quantity,
                from.price,
                from.isSold
            )
        }
    }
}
