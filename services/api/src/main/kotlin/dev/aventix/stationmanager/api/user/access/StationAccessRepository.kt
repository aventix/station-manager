package dev.aventix.stationmanager.api.user.access

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StationAccessRepository : JpaRepository<StationAccessEntity, UUID> {
    fun findByUser_KeycloakUserId(userKeycloakUserId: String): MutableList<StationAccessEntity>
}