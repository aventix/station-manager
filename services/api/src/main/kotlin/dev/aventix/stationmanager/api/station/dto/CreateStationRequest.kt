package dev.aventix.stationmanager.api.station.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class CreateStationRequest(
    @field:NotBlank
    @field:Size(max = 255)
    val name: String,

    @field:NotBlank
    @field:Pattern(regexp = "\\d+")
    val debtorNumber: String,

    @field:NotBlank
    @field:Pattern(regexp = "\\d+")
    val stationNumber: String,

    @field:NotBlank
    @field:Size(max = 500)
    val address: String,

    @field:Size(max = 100)
    val phoneNumber: String? = null,
)