package dev.aventix.stationmanager.api.station

import dev.aventix.stationmanager.api.station.dto.CreateStationRequest
import dev.aventix.stationmanager.api.station.dto.StationResponse
import dev.aventix.stationmanager.api.station.dto.UpdateStationRequest
import dev.aventix.stationmanager.api.user.UserProfileService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/stations")
class StationController(
    private val stationService: StationService,
    private val userProfileService: UserProfileService
) {
    @GetMapping()
    fun findAll(): List<StationResponse> {
        return stationService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): StationResponse {
        return stationService.findById(id)
    }

    @PostMapping
    fun create(
        @Valid @RequestBody request: CreateStationRequest
    ): StationResponse {
        return stationService.create(request)
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable id: UUID, @Valid @RequestBody request: UpdateStationRequest): StationResponse {
        return stationService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID): StationResponse {
        return stationService.delete(id)
    }
}