package dev.aventix.stationmanager.api.station.permission

import dev.aventix.stationmanager.api.station.permission.dto.PermissionResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/permissions")
class PermissionDefinitionController(private val permissionDefinitionService: PermissionDefinitionService) {
    @GetMapping
    fun findAll(): List<PermissionResponse> {
        return permissionDefinitionService.findAllPermissions()
    }
}