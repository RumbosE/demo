package com.eduardoinc.osodrink.dto.product

//TODO: Add validation
data class ProductCreateRequestDto (
    val name: String?,
    val type: String?,
    val price: Float?,
    val amount: Int?,
    val description: String?
)
