package F1.Clients;

import F1.DTO.Teams.TeamReadDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

//HTTP client of Teams-microservice (Drivers has no access to teams database, so it asks Teams over REST)
@Service
public class TeamsClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public TeamsClient(RestTemplateBuilder builder, @Value("${teams.service.url}") String baseUrl){
        this.restTemplate = builder.build();
        this.baseUrl = baseUrl;
    }

    public TeamReadDTO getTeamByUuid(UUID id){
        try{
            return restTemplate.getForObject(baseUrl + "/api/teams/{id}", TeamReadDTO.class, id);
        }
        catch(HttpClientErrorException.NotFound e){
            return null; //team doesn't exist
        }
        catch(RestClientException e){
            throw new TeamsServiceUnavailableException(e);
        }
    }
    public List<TeamReadDTO> getAllTeams(){
        try{
            TeamReadDTO[] teams = restTemplate.getForObject(baseUrl + "/api/teams", TeamReadDTO[].class);
            return teams == null ? List.of() : List.of(teams);
        }
        catch(RestClientException e){
            throw new TeamsServiceUnavailableException(e);
        }
    }
    public TeamReadDTO getTeamByName(String teamName){
        return getAllTeams().stream()
                .filter(team -> Objects.equals(team.getName(), teamName))
                .findFirst()
                .orElse(null);
    }
}
