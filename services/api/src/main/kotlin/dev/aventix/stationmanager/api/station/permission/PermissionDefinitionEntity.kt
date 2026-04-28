package dev.aventix.stationmanager.api.station.permission

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "permission_definitions")
class PermissionDefinitionEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true, length = 150)
    val key: String,

    @Column(nullable = false, length = 255)
    val description: String
)