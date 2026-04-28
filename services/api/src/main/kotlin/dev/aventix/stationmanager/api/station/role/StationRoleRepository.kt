package dev.aventix.stationmanager.api.station.role

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StationRoleRepository : JpaRepository<StationRoleEntity, UUID>