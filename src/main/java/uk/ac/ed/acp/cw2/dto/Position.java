package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a geographic position with longitude and latitude in degrees.
 */
public record Position(
        @NotNull(message = "Longitude must be provided!")
        @Min(value = -180, message = "Longitude cannot be under -180!")
        @Max(value = 180, message = "Longitude cannot be over 180!")
        Double lng,

        @NotNull(message = "Latitude must be provided!")
        @Min(value = -90, message = "Latitude cannot be under 90!")
        @Max(value = 90, message = "Latitude cannot be over 90!")
        Double lat
) {}