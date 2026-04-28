package dev.aventix.stationmanager.api.user.profile

import dev.aventix.stationmanager.api.common.security.CurrentUser
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository,
) {

    fun getOrCreateCurrentUser(): UserProfileEntity {
        val keycloakUserId = CurrentUser.getUserId()
            ?: throw IllegalStateException("No user id in token")

        return userProfileRepository.findByKeycloakUserId(keycloakUserId)
            ?: userProfileRepository.save(
                UserProfileEntity(
                    keycloakUserId = keycloakUserId,
                    email = CurrentUser.getEmail() ?: "unknown",
                )
            )
    }
}