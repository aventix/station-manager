package dev.aventix.stationmanager.api.station.role

import dev.aventix.stationmanager.api.station.StationEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.Instant
import java.util.UUID

@Entity
@Table(
    name = "station_roles",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_station_roles_station_name",
            columnNames = ["station_id", "name"]
        )
    ]
)
class StationRoleEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    val station: StationEntity,

    @Column(nullable = false, length = 100)
    var name: String,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),
)