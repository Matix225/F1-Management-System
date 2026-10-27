package F1.Controllers;

import F1.DTO.Teams.TeamDTO;
import F1.DTO.Teams.TeamReadDTO;
import F1.Entities.Team;
import F1.Services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/add")
    public ResponseEntity<TeamReadDTO> addTeam(@RequestBody TeamDTO teamDTO){
        //data validation

        //transform DTO into entity object
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setTeamLeader(teamDTO.getTeamLeader());
        team.setFirstEntry(teamDTO.getFirstEntry());
        team.setTotalRaces(teamDTO.getTotalRaces());
        team.setRacesWon(teamDTO.getRacesWon());
        team.setChampionshipsWon(teamDTO.getChampionshipsWon());

        Team savedTeam = teamService.addTeam(team);
        TeamReadDTO responseDTO = new TeamReadDTO(
                savedTeam.getUuid(),
                savedTeam.getName(),
                savedTeam.getTeamLeader(),
                savedTeam.getFirstEntry(),
                savedTeam.getChampionshipsWon()
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeamReadDTO> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable UUID id){
        //data validation

        //check if team with given id exist
        Team team = teamService.getTeamByUuid(id);
        if(team == null){//entity with given id doesn't exist
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        //transfer DTO object into entity object
        team.setName(teamDTO.getName());
        team.setTeamLeader(teamDTO.getTeamLeader());
        team.setFirstEntry(teamDTO.getFirstEntry());
        team.setTotalRaces(teamDTO.getTotalRaces());
        team.setRacesWon(teamDTO.getRacesWon());
        team.setChampionshipsWon(teamDTO.getChampionshipsWon());

        Team savedTeam = teamService.updateTeam(team);
        TeamReadDTO responseDTO = new TeamReadDTO(
                savedTeam.getUuid(),
                savedTeam.getName(),
                savedTeam.getTeamLeader(),
                savedTeam.getFirstEntry(),
                savedTeam.getChampionshipsWon()
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<TeamReadDTO>> getAllTeams(){
        List<Team> teams = teamService.getAllTeams();
        if(teams.isEmpty()){ //return empty list if no team exists
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }

        //transform every entity into his DTO reading object
        List<TeamReadDTO> teamsDTO = teams.stream()
                .map(team -> new TeamReadDTO(
                        team.getUuid(),
                        team.getName(),
                        team.getTeamLeader(),
                        team.getFirstEntry(),
                        team.getChampionshipsWon()
                ))
                .toList();
        return new ResponseEntity<>(teamsDTO, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamReadDTO> getTeam(@PathVariable UUID id){
        Team team = teamService.getTeamByUuid(id);
        if(team == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        TeamReadDTO teamDTO = new TeamReadDTO(
                team.getUuid(),
                team.getName(),
                team.getTeamLeader(),
                team.getFirstEntry(),
                team.getChampionshipsWon()
        );
        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable UUID id){
        int errCode = teamService.deleteTeam(id);
        if(errCode == -1){
            return new ResponseEntity<>("Team with this id doesn't exists!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Team successfully deleted!", HttpStatus.OK);
    }
}
