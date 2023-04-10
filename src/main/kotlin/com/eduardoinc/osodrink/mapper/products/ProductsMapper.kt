package com.eduardoinc.osodrink.mapper.products

import com.eduardoinc.osodrink.dao.Product
import com.eduardoinc.osodrink.dto.product.ProductCreateRequestDto
import com.eduardoinc.osodrink.dto.product.ProductDto

fun Product.toDto() = ProductDto(
    id = id,
    name = name,
    type = type,
    price = price,
    amount = amount,
    description = description
)

fun ProductDto.toDao() = Product(
    id = id,
    name = name,
    type = type,
    price = price,
    amount = amount,
    description = description
)

fun ProductCreateRequestDto.toDao() = Product(
    name = name ?: throw IllegalArgumentException("Name is required"),
    type = type ?: throw IllegalArgumentException("Type is required"),
    price = price ?: throw IllegalArgumentException("Price is required"),
    amount = amount ?: throw IllegalArgumentException("Amount is required"),
    description = description
)