package uk.ac.ed.acp.cw2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.ac.ed.acp.cw2.dto.Drone;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class providing functionality for drone stuff.
 */
@RequiredArgsConstructor
@Service
public class DroneService {
    private final URL serviceURl;
    private final RestTemplate restTemplate = new RestTemplate();

    private List<Drone> getDrones() {
        String endpoint  = serviceURl + "/drones";
        Drone[] drones = restTemplate.getForObject(endpoint, Drone[].class);
        if (drones == null) {return List.of();}
        return List.of(drones);
    }

    /**
     * Returns a list of drones-ids which support cooling (state is true) or not (false)
     * @param state "true" or "false"
     * @return List<Long> of drones-ids
     */
    public List<Long> getDronesWithCooling(Boolean state) {
        List<Drone> drones = getDrones();
        if (drones.isEmpty()) {return List.of();}
        List<Long> ids = new ArrayList<>();
        for (Drone drone : drones) {
            if (!drone.capability().cooling().equals(state)) {continue;}
            ids.add(drone.id());
        }
        return ids;
    }

}
