package com.eduardoinc.osodrink.dto

data class ProductDto(
    val id: Long?,
    val name: String,
    val type: String,
    val price: Float,
    val amount: Int,
    val description: String? = null
)
