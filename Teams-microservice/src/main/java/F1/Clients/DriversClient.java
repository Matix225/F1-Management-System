package F1.Clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

//HTTP client of Drivers-microservice (Teams has no access to drivers database, so it asks Drivers over REST)
@Service
public class DriversClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public DriversClient(RestTemplateBuilder builder, @Value("${drivers.service.url}") String baseUrl){
        this.restTemplate = builder.build();
        this.baseUrl = baseUrl;
    }

    public void deleteDriversOfTeam(UUID teamId){
        try{
            restTemplate.delete(baseUrl + "/api/teams/{teamId}/drivers", teamId);
        }
        catch(RestClientException e){
            throw new DriversServiceUnavailableException(e);
        }
    }
}
