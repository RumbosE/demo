package com.eduardoinc.osodrink.dao

import jakarta.persistence.*

@Entity
@Table(name = "productos")
data class Product(

    @Column(name = "nombre", length = 50)
    var name: String,

    @Column(name = "tipo", length = 30)
    var type: String,

    @Column(name = "precio")
    var price: Float,

    @Column(name = "cantidad")
    var amount: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "descripcion", length = 50)
    var description: String? = null,

    @Column
    var foto: String? = null
)
