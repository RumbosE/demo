package com.eduardoinc.osodrink.repository

import com.eduardoinc.osodrink.dao.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long>
