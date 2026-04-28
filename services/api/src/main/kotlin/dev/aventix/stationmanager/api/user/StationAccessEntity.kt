package dev.aventix.stationmanager.api.user

import dev.aventix.stationmanager.api.station.StationEntity
import dev.aventix.stationmanager.api.station.role.StationRoleEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "station_access")
class StationAccessEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserProfileEntity,

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    val station: StationEntity,

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    val role: StationRoleEntity,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),
)