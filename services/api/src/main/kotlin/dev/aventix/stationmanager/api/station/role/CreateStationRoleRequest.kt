package dev.aventix.stationmanager.api.station.role

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateStationRoleRequest(
    @field:NotBlank
    @field:Size(max = 150)
    val name: String
)