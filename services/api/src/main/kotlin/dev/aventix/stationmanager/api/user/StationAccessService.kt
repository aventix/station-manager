package dev.aventix.stationmanager.api.user

import dev.aventix.stationmanager.api.station.StationRepository
import dev.aventix.stationmanager.api.station.role.StationRoleRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StationAccessService(
    private val userProfileRepository: UserProfileRepository,
    private val stationRepository: StationRepository,
    private val stationRoleRepository: StationRoleRepository,
    private val stationAccessRepository: StationAccessRepository,
) {

    fun assignUserToStation(
        userId: UUID,
        stationId: UUID,
        roleId: UUID,
    ) {
        val user = userProfileRepository.findById(userId)
            .orElseThrow { RuntimeException("User not found") }

        val station = stationRepository.findById(stationId)
            .orElseThrow { RuntimeException("Station not found") }

        val role = stationRoleRepository.findById(roleId)
            .orElseThrow { RuntimeException("Role not found") }

        val access = StationAccessEntity(
            user = user,
            station = station,
            role = role,
        )

        stationAccessRepository.save(access)
    }
}