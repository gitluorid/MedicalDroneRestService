package uk.ac.ed.acp.cw2.dto;

/**
 * Represents a drone with an id, name, and capability.
 */
public record Drone(Long id, String name, Capability capability) {
    public record Capability(
            Boolean cooling,
            Boolean heating,
            Double capacity,
            Integer maxMoves,
            Double costPerMove,
            Double costInitial,
            Double costFinal
    ) {}
}
