package dev.aventix.stationmanager.api.common.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt

object CurrentUser {
    fun getUserId(): String? {
        val authentication = SecurityContextHolder.getContext().authentication
        val jwt = authentication?.principal as? Jwt
        return jwt?.subject
    }

    fun getEmail(): String? {
        val authentication = SecurityContextHolder.getContext().authentication
        val jwt = authentication?.principal as? Jwt
        return jwt?.getClaimAsString("email")
    }
}