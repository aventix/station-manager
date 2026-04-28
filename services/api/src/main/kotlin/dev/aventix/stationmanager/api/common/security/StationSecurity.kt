package dev.aventix.stationmanager.api.common.security

import dev.aventix.stationmanager.api.user.access.StationAccessRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class StationSecurity(
    private val stationAccessRepository: StationAccessRepository
) {
    fun hasRoleForStation(
        stationId: UUID,
        vararg requiredRoles: String
    ): Boolean {
        val keycloakUserId = CurrentUser.getUserId() ?: return false
        val allowedRoles = requiredRoles.toSet()

        return stationAccessRepository.findByUser_KeycloakUserId(keycloakUserId)
            .any { access -> access.station.id == stationId && access.role.name in allowedRoles }
    }
}