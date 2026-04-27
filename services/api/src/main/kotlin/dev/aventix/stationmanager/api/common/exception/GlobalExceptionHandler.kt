package dev.aventix.stationmanager.api.common.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(StationNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleStationNotFound(
        exception: StationNotFoundException,
        request: HttpServletRequest
    ): ApiErrorResponse {
        return ApiErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.reasonPhrase,
            message = exception.message ?: "Station not found",
            path = request.requestURI
        )
    }
}