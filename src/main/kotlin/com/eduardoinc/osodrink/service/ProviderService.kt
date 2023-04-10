package com.eduardoinc.osodrink.service

import com.eduardoinc.osodrink.dao.Provider
import com.eduardoinc.osodrink.dto.providers.ProviderCreateRequestDto
import com.eduardoinc.osodrink.dto.providers.ProviderDto
import com.eduardoinc.osodrink.dto.providers.ProviderUpdateRequestDto
import com.eduardoinc.osodrink.dto.providers.ProvidersDto
import com.eduardoinc.osodrink.mapper.providers.toDao
import com.eduardoinc.osodrink.mapper.providers.toDto
import com.eduardoinc.osodrink.repository.ProviderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.NoSuchElementException
import kotlin.jvm.optionals.getOrNull

interface IProviderService {

    fun getAllProviders(): ProvidersDto
    fun getProviderById(id: Long): ProviderDto
    fun deleteProvider(id: Long): String
    fun saveProvider(provider: ProviderCreateRequestDto): ProviderDto
    fun updateProvider(id: Long, providerRequest: ProviderUpdateRequestDto): ProviderDto
}

@Service
class ProviderServiceImpl (
    private val providerRepository: ProviderRepository
) : IProviderService {

    override fun getAllProviders(): ProvidersDto = providerRepository.findAll()
        .toList()
        .map(Provider::toDto)
        .let { ProvidersDto(it) }

    override fun getProviderById(id: Long): ProviderDto = getById(id).toDto()

    override fun deleteProvider(id: Long): String {
        val providerEliminated = getProviderById(id)
        providerRepository.deleteById(id)
        return "Provider ${providerEliminated.name} was eliminated"
    }

    override fun saveProvider(provider: ProviderCreateRequestDto): ProviderDto = providerRepository.save(provider.toDao()).toDto()

    @Transactional
    override fun updateProvider(id : Long, providerRequest: ProviderUpdateRequestDto): ProviderDto = with(providerRequest) {
        val provider = getById(id)

        name?.let { provider.name = it }
        rif?.let { provider.rif = it }
        phone?.let { provider.phone = it }
        address?.let { provider.address = it }

        provider.toDto()
    }

    private fun getById(id: Long) = providerRepository.findById(id)
    .getOrNull()
    ?: throw NoSuchElementException("Product with id $id not found")

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (this.isPresent) listOf(this.get()) else emptyList()
}



