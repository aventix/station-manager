package dev.aventix.stationmanager.api.station.dto

import jakarta.validation.constraints.Size

data class UpdateStationRequest(
    @field:Size(max = 255)
    var name: String? = null,
    @field:Size(max = 500)
    var address: String? = null,
    @field:Size(max = 100)
    var phoneNumber: String? = null
)