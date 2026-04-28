package dev.aventix.stationmanager.api.user.profile

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "user_profiles")
class UserProfileEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    val keycloakUserId: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var createdAt: Instant = Instant.now()
)