package dev.aventix.stationmanager.api.station.permission.dto

import java.util.UUID

data class PermissionResponse(
    val id: UUID,
    val key: String,
    val description: String
)
