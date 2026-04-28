package dev.aventix.stationmanager.api.station.permission

import dev.aventix.stationmanager.api.station.permission.dto.PermissionResponse
import org.springframework.stereotype.Service

@Service
class PermissionDefinitionService(private val permissionDefinitionRepository: PermissionDefinitionRepository) {
    fun findAllPermissions(): List<PermissionResponse> {
        return permissionDefinitionRepository.findAll().map { PermissionResponse(it.id, it.key, it.description) }
    }
}