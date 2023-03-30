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
    fun saveProduct(product: Product) : Product
    fun updateProduct(id: Long, product: Product): Product
}

@Service
class ProductService : IProductService {

    lateinit var db: ProductRepository

    override fun getAllProducts(): List<Product> {
        return db.findAll().toList()
    }
    override fun getProductById(id: Long): List<Product> {
        return db.findById(id.toString()).toList()
    }
    override fun deleteProduct(id: Long): String {
        var productEliminated = getProductById(id)
        db.deleteById(id.toString())
        return "Product ${productEliminated[0].nombre} was eliminated"
    }
    override fun saveProduct(product: Product): Product {
        db.save(product)
        return product
    }

    override fun updateProduct(id: Long, product: Product): Product {
        var productToUpdated = getProductById(id)
        var newProduct = getProductById(id)
            newProduct[0].nombre = product.nombre
            newProduct[0].tipo = product.tipo
            newProduct[0].precio = product.precio
            newProduct[0].cantidad = product.cantidad
            newProduct[0].descripcion = product.descripcion
            newProduct[0].foto = product.foto
            db.save(newProduct[0])
        return newProduct[0]
    }
    fun <T : Any> Optional<out T>.toList(): List<T> =
            if (this.isPresent) listOf(this.get()) else emptyList()
}



