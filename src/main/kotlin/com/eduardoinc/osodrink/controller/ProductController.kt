package com.eduardoinc.osodrink.controller

import com.eduardoinc.osodrink.service.IProductService
import org.springframework.web.bind.annotation.GetMapping
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
    fun getProduct() = productService.getProductById()
}

