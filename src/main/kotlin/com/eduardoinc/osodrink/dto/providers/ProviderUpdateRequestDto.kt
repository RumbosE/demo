package com.eduardoinc.osodrink.dto.providers

data class ProviderUpdateRequestDto(
    val name: String? = null,
    val rif: String? = null,
    val phone: String? = null,
    val address: String? = null
)