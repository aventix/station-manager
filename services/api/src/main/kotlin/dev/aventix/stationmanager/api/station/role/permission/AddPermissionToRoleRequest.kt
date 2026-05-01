package dev.aventix.stationmanager.api.station.role.permission

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class AddPermissionToRoleRequest(
    @field:NotNull
    val permissionId: UUID
)
