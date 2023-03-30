package com.eduardoinc.osodrink.dto

data class ProductDto(
        val id: Long?,
        val nombre: String,
        val tipo: String,
        val precio: Float,
        val cantidad: Int,
        val descripcion: String? = null,
        val foto: String? = null
)

data class ProductsDto(
    val products: List<ProductDto>
)

