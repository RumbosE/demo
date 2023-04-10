package com.eduardoinc.osodrink.dto.providers

data class ProviderCreateRequestDto(
    val name: String?,
    val rif: String?,
    val phone: String?,
    val address: String?
)