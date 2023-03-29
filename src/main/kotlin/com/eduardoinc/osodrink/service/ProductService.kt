package com.eduardoinc.osodrink.service

import ProductRepository
import com.eduardoinc.osodrink.dao.Product
import com.eduardoinc.osodrink.dto.ProductDto
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

interface IProductService {
    fun getAllProducts(): List<ProductDto>
    fun getProductById(id: Int): ProductDto
    fun deleteProduct()

}

@Service
class ProductService (val db:ProductRepository): IProductService {
    override fun getAllProducts(): List<ProductDto> = db.findAll().toList()

    override fun getProductById(id: Int): List<ProducDto> = db.findById(id).toList()
}