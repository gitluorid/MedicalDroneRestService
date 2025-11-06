package uk.ac.ed.acp.cw2.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Represents a polygonal region defined by a name and a list of vertices.
 */
public record Region(
        @NotNull(message = "Region name is required!")
        String name,

        @NotNull(message = "Vertices are required!")
        @Size(min = 4, message = "Region must have at least 4 vertices!")
        @Valid
        List<Position> vertices
) {}
