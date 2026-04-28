package dev.aventix.stationmanager.api.station.role.permission

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StationRolePermissionRepository : JpaRepository<StationRolePermissionEntity, UUID> {
    fun findByRole_Id(roleId: UUID): List<StationRolePermissionEntity>

    fun findByRoleIdIn(roles: Collection<UUID>): List<StationRolePermissionEntity>
}