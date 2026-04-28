package dev.aventix.stationmanager.api.station.permission

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PermissionDefinitionRepository : JpaRepository<PermissionDefinitionEntity, UUID> {
    fun findByKey(key: String): PermissionDefinitionEntity?
}