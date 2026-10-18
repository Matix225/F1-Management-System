package F1.Services;

import F1.Entities.Team;
import F1.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    public List<Team> showTeams(){
            return teamRepository.findAll();
    }
}
