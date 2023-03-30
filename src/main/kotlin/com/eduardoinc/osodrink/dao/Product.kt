package com.eduardoinc.osodrink.dao

import com.eduardoinc.osodrink.dto.ProductDto
import jakarta.persistence.*

@Entity
@Table(name = "productos")
data class Product(

    @Column(length = 50)
    var nombre: String,

    @Column(length = 30)
    var tipo: String,

    @Column
    var precio: Float,

    @Column
    var cantidad: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 50)
    var descripcion: String? = null,

    @Column
    var foto: String? = null
) {
    fun toDto() {
        ProductDto(
            id = id,
            nombre = nombre,
            tipo = tipo,
            precio = precio,
            cantidad = cantidad,
            descripcion = descripcion,
            foto = foto
        )
    }
}