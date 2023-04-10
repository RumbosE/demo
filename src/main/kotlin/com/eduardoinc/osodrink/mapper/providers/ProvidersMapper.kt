package com.eduardoinc.osodrink.mapper.providers

import com.eduardoinc.osodrink.dao.Provider
import com.eduardoinc.osodrink.dto.providers.ProviderCreateRequestDto
import com.eduardoinc.osodrink.dto.providers.ProviderDto

fun Provider.toDto() = ProviderDto(
    id = id,
    name = name,
    rif = rif,
    phone = phone,
    address = address,
)

fun ProviderDto.toDao() = Provider(
    id = id,
    name = name,
    rif = rif,
    phone = phone,
    address = address,
)

fun ProviderCreateRequestDto.toDao() = Provider(
    name = name ?: throw IllegalArgumentException("Name is required"),
    rif = rif ?: throw IllegalArgumentException("Rif is required"),
    phone = phone ?: throw IllegalArgumentException("Phone is required"),
    address = address ?: throw IllegalArgumentException("Address is required"),
)