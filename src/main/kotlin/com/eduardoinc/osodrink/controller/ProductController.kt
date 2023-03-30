package com.eduardoinc.osodrink.controller

import com.eduardoinc.osodrink.dao.Product
import com.eduardoinc.osodrink.service.IProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/productos")
class ProductController(
    private val productService: IProductService
) {
    @GetMapping("/")
    fun getAll() = productService.getAllProducts()

    @GetMapping(":id/")
    fun getProduct(@PathVariable("id") id: Long): List<Product> {
        return productService.getProductById(id)
    }

    @GetMapping(":id/")
    fun deleteProduct(@PathVariable("id") id: Long): String {
        return productService.deleteProduct(id)
    }

    @PostMapping("/")
    fun saveProduct(@RequestBody product: Product): Product {
        return productService.saveProduct(product)
    }

    @PatchMapping(":id/")
    fun updateProduct(@PathVariable("id") id: Long, @RequestBody product: Product): Product {
        return productService.saveProduct(product)
    }


}

