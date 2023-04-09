package com.eduardoinc.osodrink.dto

data class ProductUpdateRequestDto(
    val name: String? = null,
    val type: String? = null,
    val price: Float? = null,
    val amount: Int? = null,
    val description: String? = null
)
