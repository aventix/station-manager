package dev.aventix.stationmanager.api.common.exception

import java.util.UUID

class StationNotFoundException(id: UUID) : RuntimeException("Could not find station with id $id")