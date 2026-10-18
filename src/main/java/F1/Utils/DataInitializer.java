package F1.Utils;

import F1.Entities.Driver;
import F1.Entities.Team;
import F1.Services.DriverService;
import F1.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

@Component
public class DataInitializer {
    private final DriverService driverService;
    private final TeamService teamService;

    @Autowired
    public DataInitializer(DriverService driverService, TeamService teamService){
        this.driverService = driverService;
        this.teamService = teamService;
    }

    public void initData(){
        initTeams();
        initDrivers();
    }

    public void initTeams(){
        Team redBull = new Team();
        redBull.setUuid(UUID.randomUUID());
        redBull.setName("Oracle Red Bull Racing");
        redBull.setFirstEntry(2005);
        redBull.setCountry("Austria");
        redBull.setHeadquarters("Milton Keynes");
        redBull.setTeamLeader("Laurent Mekies");
        redBull.setTotalRaces(434);
        redBull.setRacesWon(131);
        redBull.setPodiums(242);
        redBull.setChampionshipsWon(6);
        teamService.addTeam(redBull);

        Team mercedes = new Team();
        mercedes.setUuid(UUID.randomUUID());
        mercedes.setName("Mercedes-AMG Petronas Formula One F1.Team");
        mercedes.setFirstEntry(1970);
        mercedes.setCountry("Germany");
        mercedes.setHeadquarters("Brackley");
        mercedes.setTeamLeader("Toto Wolff");
        mercedes.setTotalRaces(345);
        mercedes.setRacesWon(133);
        mercedes.setPodiums(217);
        mercedes.setChampionshipsWon(8);
        teamService.addTeam(mercedes);
    }
    public void initDrivers(){
        List<Team> teams = teamService.getAllTeams();
        Team redBull = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Oracle Red Bull Racing"))
                .findFirst()
                .orElse(null);

        if(redBull != null){
            Driver red1 = new Driver();
            red1.setUuid(UUID.randomUUID());
            red1.setFirstName("Max");
            red1.setLastName("Verstappen");
            red1.setAge(29);
            red1.setRaceNumber(3);
            red1.setCurrentTeam(redBull);
            red1.setRacesEntered(249);
            red1.setRacesWon(72);
            red1.setPodiums(135);
            red1.setPolePositions(49);
            red1.setTitlesWon(4);
            driverService.addDriver(red1);

            Driver red2 = new Driver();
            red2.setUuid(UUID.randomUUID());
            red2.setFirstName("Isac");
            red2.setLastName("Hadjar");
            red2.setAge(22);
            red2.setRaceNumber(6);
            red2.setCurrentTeam(redBull);
            red2.setRacesEntered(36);
            red2.setRacesWon(0);
            red2.setPodiums(3);
            red2.setPolePositions(0);
            red2.setTitlesWon(0);
            driverService.addDriver(red2);
        }
    }
}
