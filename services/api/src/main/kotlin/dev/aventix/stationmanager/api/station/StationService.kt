package dev.aventix.stationmanager.api.station

import dev.aventix.stationmanager.api.common.exception.StationNotFoundException
import dev.aventix.stationmanager.api.station.dto.CreateStationRequest
import dev.aventix.stationmanager.api.station.dto.StationResponse
import dev.aventix.stationmanager.api.station.dto.UpdateStationRequest
import dev.aventix.stationmanager.api.user.StationAccessRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StationService(
    private val stationRepository: StationRepository,
    private val stationAccessRepository: StationAccessRepository,
) {
    fun findAll(): List<StationResponse> {
        return stationRepository.findAll().map { it.toResponse() }
    }

    fun findById(id: UUID): StationResponse {
        val station =
            stationRepository.findById(id).orElseThrow { StationNotFoundException(id) }

        return station.toResponse()
    }

    fun create(request: CreateStationRequest): StationResponse {
        val station = StationEntity(
            name = request.name,
            debtorNumber = request.debtorNumber,
            stationNumber = request.stationNumber,
            address = request.address,
            phoneNumber = request.phoneNumber,
        )

        return stationRepository.save(station).toResponse()
    }

    fun update(id: UUID, request: UpdateStationRequest): StationResponse {
        val station = stationRepository.findById(id).orElseThrow { StationNotFoundException(id) }

        request.name?.let { station.name = it }
        request.address?.let { station.address = it }
        request.phoneNumber?.let { station.phoneNumber = it }

        return stationRepository.save(station).toResponse()
    }

    fun delete(id: UUID): StationResponse {
        val station = stationRepository.findById(id).orElseThrow { StationNotFoundException(id) }
        station.active = true

        return stationRepository.save(station).toResponse()
    }

    fun findStationsFromUser(keyCloakUserId: String): List<StationResponse> {
        return stationAccessRepository.findByUser_KeycloakUserId(keyCloakUserId).map { it.station.toResponse() }
    }

    private fun StationEntity.toResponse(): StationResponse {
        return StationResponse(
            id = id,
            name = name,
            debtorNumber = debtorNumber,
            stationNumber = stationNumber,
            address = address,
            phoneNumber = phoneNumber,
            active = active,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}