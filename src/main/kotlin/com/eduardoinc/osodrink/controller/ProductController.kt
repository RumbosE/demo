package com.eduardoinc.osodrink.controller

import com.eduardoinc.osodrink.dto.ProductCreateRequestDto
import com.eduardoinc.osodrink.dto.ProductUpdateRequestDto
import com.eduardoinc.osodrink.service.IProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/products")
class ProductController(
    private val productService: IProductService
) {
    @GetMapping("/")
    fun getAll() = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id") id: Long) = productService.getProductById(id)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Long) = productService.deleteProduct(id)

    @PostMapping("/")
    fun saveProduct(@RequestBody product: ProductCreateRequestDto) = productService.saveProduct(product)

    @PatchMapping("/{id}")
    fun updateProduct(@PathVariable("id") id: Long, @RequestBody product: ProductUpdateRequestDto) =
        productService.updateProduct(id, product)
}

