package dev.aventix.stationmanager.api.station

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "stations")
class StationEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    val debtorNumber: String,

    @Column(nullable = false, unique = true)
    val stationNumber: String,

    @Column(nullable = false)
    var address: String,

    @Column
    var phoneNumber: String? = null,

    @Column(nullable = false)
    var active: Boolean = true,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),

    @Column(nullable = false)
    var updatedAt: Instant = Instant.now()
) {
    @PreUpdate
    fun preUpdate() {
        updatedAt = Instant.now()
    }
}