package F1.Controllers;

import F1.DTO.Drivers.DriverDTO;
import F1.DTO.Drivers.DriverReadDTO;
import F1.DTO.Teams.TeamReadDTO;
import F1.Entities.Driver;
import F1.Services.DriverService;
import F1.Clients.TeamsClient;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController()
@RequestMapping("/api")
public class DriverController{
    private final DriverService driverService;
    private final TeamsClient teamsClient;

    public DriverController(DriverService driverService, TeamsClient teamsClient) {
        this.driverService = driverService;
        this.teamsClient = teamsClient;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverReadDTO>> getAllDrivers(){
        List<Driver> drivers = driverService.getAllDrivers();
        if(drivers.isEmpty()){
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }

        //team names are kept in Teams-microservice
        Map<UUID, String> teamNames = new HashMap<>();
        teamsClient.getAllTeams().forEach(team -> teamNames.put(team.getId(), team.getName()));

        List<DriverReadDTO> responseDTO = drivers.stream()
                .map(driver -> {
                    String tmp = teamNames.getOrDefault(driver.getTeamId(), "");
                    return new DriverReadDTO(
                            driver.getUuid(),
                            driver.getFirstName(),
                            driver.getLastName(),
                            driver.getRaceNumber(),
                            tmp
                    );
                })
                .toList();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/teams/{teamId}/drivers")
    public ResponseEntity<List<DriverReadDTO>> getTeamDrivers(@PathVariable UUID teamId){
        TeamReadDTO team = teamsClient.getTeamByUuid(teamId);
        if(team == null){
            return new ResponseEntity<>(List.of(), HttpStatus.NOT_FOUND);
        }

        List<Driver> drivers = driverService.getDriversByTeamId(teamId);
        if(drivers == null){
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }

        List<DriverReadDTO> responseDTO = drivers.stream()
                .map(driver -> new DriverReadDTO(
                        driver.getUuid(),
                        driver.getFirstName(),
                        driver.getLastName(),
                        driver.getRaceNumber(),
                        team.getName()
                ))
                .toList();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/teams/{teamId}/drivers")
    public ResponseEntity<DriverReadDTO> addDriver(@RequestBody @Valid DriverDTO driverDTO, @PathVariable UUID teamId){
        //check if team exists
        TeamReadDTO team = teamsClient.getTeamByUuid(teamId);
        if(team == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        //change DTO object into entity object
        Driver driver = new Driver();
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setAge(driverDTO.getAge());
        driver.setRaceNumber(driverDTO.getRaceNumber());
        driver.setRacesEntered(driverDTO.getRacesEntered());
        driver.setRacesWon(driverDTO.getRacesWon());
        driver.setTitlesWon(driverDTO.getTitlesWon());
        driver.setTeamId(team.getId());

        Driver savedDriver = driverService.addDriver(driver);
        //change saved driver into his DTO and send it back to the user
        DriverReadDTO responseDTO = new DriverReadDTO(
                savedDriver.getUuid(),
                savedDriver.getFirstName(),
                savedDriver.getLastName(),
                savedDriver.getRaceNumber(),
                team.getName() //driver will always have a team here, so NullPointerException is not possible
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/teams/{teamId}/drivers/{driverId}")
    public ResponseEntity<DriverReadDTO> updateDriver(@RequestBody @Valid DriverDTO driverDTO, @PathVariable UUID teamId, @PathVariable UUID driverId){
        //check if chosen team exists.
        //if user didn't change driver team, it remains the same
        TeamReadDTO team = teamsClient.getTeamByUuid(teamId);
        if(team == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        //check if driver exists in database
        Driver driver = driverService.getDriverByUuid(driverId);
        if(driver == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setAge(driverDTO.getAge());
        driver.setRaceNumber(driverDTO.getRaceNumber());
        driver.setRacesEntered(driverDTO.getRacesEntered());
        driver.setRacesWon(driverDTO.getRacesWon());
        driver.setTitlesWon(driverDTO.getTitlesWon());
        driver.setTeamId(team.getId());

        Driver savedDriver = driverService.updateDriver(driver);
        DriverReadDTO responseDTO = new DriverReadDTO(
                savedDriver.getUuid(),
                savedDriver.getFirstName(),
                savedDriver.getLastName(),
                savedDriver.getRaceNumber(),
                team.getName()
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //called by Teams-microservice when a team is deleted
    @DeleteMapping("/teams/{teamId}/drivers")
    public ResponseEntity<String> deleteTeamDrivers(@PathVariable UUID teamId){
        driverService.deleteDriversByTeamId(teamId);
        return new ResponseEntity<>("Drivers of the team deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable UUID id){
        if(driverService.getDriverByUuid(id) == null){
            return new ResponseEntity<>("Driver doesn't exists", HttpStatus.NOT_FOUND);
        }

        driverService.deleteDriverByUUID(id);
        return new ResponseEntity<>("Driver deleted!", HttpStatus.OK);
    }
}
