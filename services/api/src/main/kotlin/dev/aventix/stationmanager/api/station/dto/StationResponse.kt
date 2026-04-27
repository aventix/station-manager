package dev.aventix.stationmanager.api.station.dto

import java.time.Instant
import java.util.UUID

data class StationResponse(
    val id: UUID,
    val name: String,
    val debtorNumber: String,
    val stationNumber: String,
    val address: String,
    val phoneNumber: String?,
    val active: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
)