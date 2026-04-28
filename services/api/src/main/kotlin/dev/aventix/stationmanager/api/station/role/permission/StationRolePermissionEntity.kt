package dev.aventix.stationmanager.api.station.role.permission

import dev.aventix.stationmanager.api.station.permission.PermissionDefinitionEntity
import dev.aventix.stationmanager.api.station.role.StationRoleEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.util.UUID

@Entity
@Table(
    name = "station_role_permissions",
    uniqueConstraints = [UniqueConstraint(
        name = "uk_station_role_permissions_role_permission",
        columnNames = ["role_id", "permission_id"]
    )]
)
class StationRolePermissionEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    val role: StationRoleEntity,

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    val permission: PermissionDefinitionEntity
)