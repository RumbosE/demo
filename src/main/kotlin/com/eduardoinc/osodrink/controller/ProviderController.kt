package com.eduardoinc.osodrink.controller

import com.eduardoinc.osodrink.dto.providers.ProviderCreateRequestDto
import com.eduardoinc.osodrink.dto.providers.ProviderUpdateRequestDto
import com.eduardoinc.osodrink.service.IProductService
import com.eduardoinc.osodrink.service.IProviderService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/providers")
class ProviderController (
    private val providerService: IProviderService
) {
    @GetMapping("/")
    fun getAll() = providerService.getAllProviders()

    @GetMapping("/{id}")
    fun getProvider(@PathVariable("id") id: Long) = providerService.getProviderById(id)

    @DeleteMapping("/{id}")
    fun deleteProvider(@PathVariable("id") id: Long) = providerService.deleteProvider(id)

    @PostMapping("/")
    fun saveProvider(@RequestBody provider: ProviderCreateRequestDto) = providerService.saveProvider(provider)

    @PatchMapping("/{id}")
    fun updateProvider(@PathVariable("id") id: Long, @RequestBody provider: ProviderUpdateRequestDto) =
        providerService.updateProvider(id, provider)
}