package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a request involving two positions, used for distance calculations.
 */
public record DistanceRequest(
        @NotNull(message = "Position1 is required!")
        @Valid
        Position position1,

        @NotNull(message = "Position2 is required!")
        @Valid
        Position position2
) {}