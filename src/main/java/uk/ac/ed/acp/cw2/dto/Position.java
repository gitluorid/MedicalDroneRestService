package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Represents a geographic position with longitude and latitude in degrees.
 */
public record Position(
        @NotNull(message = "Longitude must be provided!") Double lng,
        @NotNull(message = "Latitude must be provided!") Double lat
) {}