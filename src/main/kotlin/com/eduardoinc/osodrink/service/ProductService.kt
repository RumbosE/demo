package com.eduardoinc.osodrink.service

import ProductRepository
import com.eduardoinc.osodrink.dao.Product
import com.eduardoinc.osodrink.dto.ProductDto
import org.springframework.stereotype.Service
import java.util.*

interface IProductService {
    fun getAllProducts(): List<Product>
    fun getProductById(id: Long): List<Product>
    fun deleteProduct(id: Long): String
    fun saveProduct(product: Product) : String
}

@Service
class ProductService : IProductService {

    lateinit var db: ProductRepository

    override fun getAllProducts(): List<Product> {
        return db.findAll().toList()
    }

    override fun getProductById(id: Long): List<Product> = db.findById(id.toString()).toList()
    override fun deleteProduct(id: Long): String {
        db.deleteById(id.toString())
        return "Product eliminated"
    }
    override fun saveProduct(product: Product): String {
        db.save(product)
        return "Product saved"
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
            if (this.isPresent) listOf(this.get()) else emptyList()
}



