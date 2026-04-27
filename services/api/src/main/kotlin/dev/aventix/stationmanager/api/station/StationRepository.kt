package dev.aventix.stationmanager.api.station

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StationRepository : JpaRepository<StationEntity, UUID> {
}