package F1.Services;

import F1.Clients.DriversClient;
import F1.Entities.Team;
import F1.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final DriversClient driversClient;

    public TeamService(TeamRepository teamRepository, DriversClient driversClient){
        this.teamRepository = teamRepository;
        this.driversClient = driversClient;
    }

    public Team getTeamByUuid(UUID id){
        return teamRepository.getByUuid(id);
    }
    public Team getTeamByName(String teamName){
        return teamRepository.getTeamByName(teamName);
    }
    public List<Team> getAllTeams(){
            return teamRepository.findAll();
    }



    public Team addTeam(Team team){
        team.setUuid(UUID.randomUUID());
        return teamRepository.save(team);
    }
    public int deleteTeam(UUID id){
        Team team = teamRepository.getByUuid(id);
        if(team == null){
            System.out.println("Team doesn't exists!");
            return -1;
        }

        //drivers of this team live in Drivers-microservice, so they have to be deleted there first
        driversClient.deleteDriversOfTeam(id);

        teamRepository.delete(team);
        return 0;
    }
    public Team updateTeam(Team team){
        return teamRepository.save(team);
    }
}
