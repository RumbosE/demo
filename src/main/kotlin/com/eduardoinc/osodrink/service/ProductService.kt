package com.eduardoinc.osodrink.service

import com.eduardoinc.osodrink.repository.ProductRepository
import com.eduardoinc.osodrink.dao.Product
import com.eduardoinc.osodrink.dto.product.ProductCreateRequestDto
import com.eduardoinc.osodrink.dto.product.ProductDto
import com.eduardoinc.osodrink.dto.product.ProductUpdateRequestDto
import com.eduardoinc.osodrink.dto.product.ProductsDto
import com.eduardoinc.osodrink.mapper.products.toDao
import com.eduardoinc.osodrink.mapper.products.toDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.jvm.optionals.getOrNull

interface IProductService {
    fun getAllProducts(): ProductsDto
    fun getProductById(id: Long): ProductDto
    fun deleteProduct(id: Long): String
    fun saveProduct(product: ProductCreateRequestDto) : ProductDto
    fun updateProduct(id: Long, productRequest: ProductUpdateRequestDto): ProductDto
}

@Service
class ProductService(
    private val productRepository: ProductRepository
) : IProductService {

    //TODO: Return page of products
    override fun getAllProducts(): ProductsDto = productRepository.findAll()
        .toList()
        .map(Product::toDto)
        .let { ProductsDto(it) }

    override fun getProductById(id: Long): ProductDto = getById(id).toDto()

    override fun deleteProduct(id: Long): String {
        val productEliminated = getProductById(id)
        productRepository.deleteById(id)
        return "Product ${productEliminated.name} was eliminated"
    }

    override fun saveProduct(product: ProductCreateRequestDto): ProductDto = productRepository.save(product.toDao()).toDto()

    @Transactional
    override fun updateProduct(id: Long, productRequest: ProductUpdateRequestDto): ProductDto = with(productRequest) {
        val product = getById(id)

        name?.let { product.name = it }
        type?.let { product.type = it }
        price?.let { product.price = it }
        amount?.let { product.amount = it }
        description?.let { product.description = it }

        product.toDto()
    }

    private fun getById(id: Long) = productRepository.findById(id)
        .getOrNull()
        ?: throw NoSuchElementException("Product with id $id not found")

    fun <T : Any> Optional<out T>.toList(): List<T> =
            if (this.isPresent) listOf(this.get()) else emptyList()
}



