package dev.aventix.stationmanager.api.station.role

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/stations/{stationId}/roles")
class StationRoleController(private val stationRoleService: StationRoleService) {
    @PostMapping
    fun createRole(
        @PathVariable stationId: UUID,
        @Valid @RequestBody request: CreateStationRoleRequest
    ): Map<String, String> {
        val role = stationRoleService.createRole(stationId, request)

        return mapOf(
            "id" to role.id.toString(),
            "name" to role.name
        )
    }
}