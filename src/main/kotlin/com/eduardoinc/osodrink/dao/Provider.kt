package com.eduardoinc.osodrink.dao

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "proveedores")
data class Provider(

    @Column( name = "nombre", length = 50)
    var name: String,

    @Column( length = 20)
    var rif: String,

    @Column( name= "telefono", length = 50)
    var phone: String,

    @Column( name = "direccion", length = 50)
    var address: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

)
