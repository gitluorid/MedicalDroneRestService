package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a request to calculate the next drone position from a start position and angle.
 */
public record NextPositionRequest(
        @NotNull(message = "Position is required!")
        @Valid
        Position start,

        @NotNull(message = "Angle is required!")
        @Min(0)
        @Max(360)
        Double angle
) {}

