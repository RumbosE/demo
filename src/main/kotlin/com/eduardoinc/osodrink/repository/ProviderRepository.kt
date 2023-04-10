package com.eduardoinc.osodrink.repository

import com.eduardoinc.osodrink.dao.Provider
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProviderRepository : CrudRepository<Provider, Long> {
}