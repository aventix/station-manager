package dev.aventix.stationmanager.api.station.role.permission

import dev.aventix.stationmanager.api.common.security.CurrentUser
import dev.aventix.stationmanager.api.station.permission.PermissionDefinitionRepository
import dev.aventix.stationmanager.api.station.role.StationRoleRepository
import dev.aventix.stationmanager.api.user.access.StationAccessRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class StationRolePermissionService(
    private val stationAccessRepository: StationAccessRepository,
    private val stationRolePermissionRepository: StationRolePermissionRepository,
    private val stationRoleRepository: StationRoleRepository,
    private val permissionDefinitionRepository: PermissionDefinitionRepository
) {
    fun addPermissionToRole(roleId: UUID, request: AddPermissionToRoleRequest) {
        val role = stationRoleRepository.findById(roleId)
            .orElseThrow { RuntimeException("Could not find role with id $roleId") }

        requireCurrentUserPermission(role.station.id, "station.roles.permission.add")

        val permission = permissionDefinitionRepository.findById(request.permissionId)
            .orElseThrow { RuntimeException("Could not find permission with id ${request.permissionId}") }

        val rolePermission = StationRolePermissionEntity(
            role = role,
            permission = permission
        )

        stationRolePermissionRepository.save(rolePermission)
    }

    private fun hasCurrentUserPermissions(stationId: UUID, permissionKey: String): Boolean {
        val keycloakUserId = CurrentUser.getUserId() ?: return false

        return hasUserPermission(keycloakUserId = keycloakUserId, stationId = stationId, permissionKey = permissionKey)
    }

    fun requireCurrentUserPermission(stationId: UUID, permissionKey: String) {
        if (!hasCurrentUserPermissions(stationId, permissionKey)) {
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Missing permission: $permissionKey")
        }
    }

    fun hasUserPermission(keycloakUserId: String, stationId: UUID, permissionKey: String): Boolean {
        val accesses =
            stationAccessRepository.findByUser_KeycloakUserId(keycloakUserId).filter { it.station.id == stationId }

        if (accesses.isEmpty()) return false

        val roleIds = accesses.map { it.role.id }

        return stationRolePermissionRepository.findByRoleIdIn(roleIds).any { it.permission.key == permissionKey }
    }
}