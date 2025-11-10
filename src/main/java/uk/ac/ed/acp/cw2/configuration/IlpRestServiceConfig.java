package uk.ac.ed.acp.cw2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import uk.ac.ed.acp.cw2.data.RuntimeEnvironment;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Configuration
@EnableScheduling
public class IlpRestServiceConfig {

    /**
     * Bean to retrieve the ILP REST Service URL from an environment variable or default value.
     * @return the ILP REST Service URL
     * @throws Exception if the URL is invalid
     */
    @Bean
    public URL ilpRestServiceUrl() throws Exception  {
        String defaultURL = "https://ilp-rest-2025-bvh6e9hschfagrgy.ukwest-01.azurewebsites.net";
        String endpoint = System.getenv("ILP_ENDPOINT");

        String urlString;
        // if the endpoint is not set then use the default
        if (endpoint == null || endpoint.isEmpty()) {
            urlString = defaultURL;
        } else {
            urlString = endpoint;
        }
        return new URI(urlString).toURL();
    }

}
