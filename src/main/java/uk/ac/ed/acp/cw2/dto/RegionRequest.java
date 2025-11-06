package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a request to check if a position is inside a region.
 * Contains the position to check and the target region.
 */
public record RegionRequest(
        @NotNull(message = "Position is required!")
        @Valid
        Position position,

        @NotNull(message = "Region is required!")
        @Valid
        Region region
) {}
