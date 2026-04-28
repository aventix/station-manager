package dev.aventix.stationmanager.api.station.role

import dev.aventix.stationmanager.api.station.StationRepository
import dev.aventix.stationmanager.api.station.role.permission.StationRolePermissionService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StationRoleService(
    private val stationRepository: StationRepository,
    private val stationRoleRepository: StationRoleRepository,
    private val stationRolePermissionService: StationRolePermissionService
) {
    fun createRole(stationId: UUID, request: CreateStationRoleRequest): StationRoleEntity {
        stationRolePermissionService.requireCurrentUserPermission(stationId, "station.role.create")

        val station = stationRepository.findById(stationId)
            .orElseThrow { RuntimeException("Could not find station with id $stationId") }
        val role = StationRoleEntity(
            station = station,
            name = request.name
        )

        return stationRoleRepository.save(role)
    }
}