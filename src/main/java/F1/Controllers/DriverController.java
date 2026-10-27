package F1.Controllers;

import F1.DTO.Drivers.DriverReadDTO;
import F1.Entities.Driver;
import F1.Entities.Team;
import F1.Services.DriverService;
import F1.Services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api")
public class DriverController{
    private final DriverService driverService;
    private final TeamService teamService;

    public DriverController(DriverService driverService, TeamService teamService) {
        this.driverService = driverService;
        this.teamService = teamService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverReadDTO>> getAllDrivers(){
        List<Driver> drivers = driverService.getAllDrivers();
        if(drivers.isEmpty()){
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }

        List<DriverReadDTO> responseDTO = drivers.stream()
                .map(driver -> {
                    String tmp = "";
                    if(driver.getCurrentTeam() != null){
                        tmp = driver.getCurrentTeam().getName();
                    }
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
        Team team = teamService.getTeamByUuid(teamId);
        if(team == null){
            return new ResponseEntity<>(List.of(), HttpStatus.NOT_FOUND);
        }

        List<Driver> drivers = team.getDrivers();
        if(drivers == null){
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }

        List<DriverReadDTO> responseDTO = drivers.stream()
                .map(driver -> new DriverReadDTO(
                        driver.getUuid(),
                        driver.getFirstName(),
                        driver.getLastName(),
                        driver.getRaceNumber(),
                        driver.getCurrentTeam().getName()
                ))
                .toList();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
