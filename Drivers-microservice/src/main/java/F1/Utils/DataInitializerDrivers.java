package F1.Utils;

import F1.Entities.Driver;
import F1.DTO.Teams.TeamReadDTO;
import F1.Services.DriverService;
import F1.Clients.TeamsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class DataInitializerDrivers {
    private final DriverService driverService;
    private final TeamsClient teamsClient;

    @Autowired
    public DataInitializerDrivers(DriverService driverService, TeamsClient teamsClient){
        this.driverService = driverService;
        this.teamsClient = teamsClient;
    }

    public void initData(){
        //teams are created by Teams-microservice, so it has to be running
        try{
            initDrivers();
        }
        catch(RuntimeException e){
            System.out.println("Drivers not initialized: " + e.getMessage());
        }
    }
    public void initDrivers(){
        List<TeamReadDTO> teams = teamsClient.getAllTeams();

        TeamReadDTO redBull = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Oracle Red Bull Racing"))
                .findFirst()
                .orElse(null);

        if(redBull != null){
            Driver red1 = new Driver();
            red1.setUuid(generatePositiveUuid());
            red1.setFirstName("Max");
            red1.setLastName("Verstappen");
            red1.setAge(29);
            red1.setRaceNumber(3);
            red1.setTeamId(redBull.getId());
            red1.setRacesEntered(249);
            red1.setRacesWon(72);
            red1.setPodiums(135);
            red1.setPolePositions(49);
            red1.setTitlesWon(4);
            driverService.addDriver(red1);

            Driver red2 = new Driver();
            red2.setUuid(generatePositiveUuid());
            red2.setFirstName("Isac");
            red2.setLastName("Hadjar");
            red2.setAge(22);
            red2.setRaceNumber(6);
            red2.setTeamId(redBull.getId());
            red2.setRacesEntered(36);
            red2.setRacesWon(0);
            red2.setPodiums(3);
            red2.setPolePositions(0);
            red2.setTitlesWon(0);
            driverService.addDriver(red2);
        }

        TeamReadDTO mercedes = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Mercedes-AMG Petronas Formula One Team"))
                .findFirst()
                .orElse(null);

        if(mercedes != null){
            Driver mer1 = new Driver();
            mer1.setUuid(generatePositiveUuid());
            mer1.setFirstName("George");
            mer1.setLastName("Russell");
            mer1.setAge(28);
            mer1.setRaceNumber(63);
            mer1.setTeamId(mercedes.getId());
            mer1.setRacesEntered(168);
            mer1.setRacesWon(8);
            mer1.setPodiums(32);
            mer1.setPolePositions(13);
            mer1.setTitlesWon(0);
            driverService.addDriver(mer1);

            Driver mer2 = new Driver();
            mer2.setUuid(generatePositiveUuid());
            mer2.setFirstName("Kimi");
            mer2.setLastName("Antonelli");
            mer2.setAge(20);
            mer2.setRaceNumber(12);
            mer2.setTeamId(mercedes.getId());
            mer2.setRacesEntered(40);
            mer2.setRacesWon(8);
            mer2.setPodiums(16);
            mer2.setPolePositions(6);
            mer2.setTitlesWon(0);
            driverService.addDriver(mer2);
        }

        TeamReadDTO ferrari = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Scuderia Ferrari HP"))
                .findFirst()
                .orElse(null);

        if(ferrari != null){
            Driver fer1 = new Driver();
            fer1.setUuid(generatePositiveUuid());
            fer1.setFirstName("Charles");
            fer1.setLastName("Leclerc");
            fer1.setAge(29);
            fer1.setRaceNumber(16);
            fer1.setTeamId(ferrari.getId());
            fer1.setRacesEntered(165);
            fer1.setRacesWon(9);
            fer1.setPodiums(43);
            fer1.setPolePositions(26);
            fer1.setTitlesWon(0);
            driverService.addDriver(fer1);

            Driver fer2 = new Driver();
            fer2.setUuid(generatePositiveUuid());
            fer2.setFirstName("Lewis");
            fer2.setLastName("Hamilton");
            fer2.setAge(41);
            fer2.setRaceNumber(44);
            fer2.setTeamId(ferrari.getId());
            fer2.setRacesEntered(356);
            fer2.setRacesWon(105);
            fer2.setPodiums(201);
            fer2.setPolePositions(104);
            fer2.setTitlesWon(7);
            driverService.addDriver(fer2);
        }

        TeamReadDTO mclaren = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "McLaren Formula 1 Team"))
                .findFirst()
                .orElse(null);

        if(mclaren != null){
            Driver mcl1 = new Driver();
            mcl1.setUuid(generatePositiveUuid());
            mcl1.setFirstName("Lando");
            mcl1.setLastName("Norris");
            mcl1.setAge(27);
            mcl1.setRaceNumber(4);
            mcl1.setTeamId(mclaren.getId());
            mcl1.setRacesEntered(148);
            mcl1.setRacesWon(8);
            mcl1.setPodiums(35);
            mcl1.setPolePositions(10);
            mcl1.setTitlesWon(1);
            driverService.addDriver(mcl1);

            Driver mcl2 = new Driver();
            mcl2.setUuid(generatePositiveUuid());
            mcl2.setFirstName("Oscar");
            mcl2.setLastName("Piastri");
            mcl2.setAge(25);
            mcl2.setRaceNumber(81);
            mcl2.setTeamId(mclaren.getId());
            mcl2.setRacesEntered(68);
            mcl2.setRacesWon(5);
            mcl2.setPodiums(22);
            mcl2.setPolePositions(2);
            mcl2.setTitlesWon(0);
            driverService.addDriver(mcl2);
        }

        TeamReadDTO astonMartin = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Aston Martin Aramco Formula One Team"))
                .findFirst()
                .orElse(null);

        if(astonMartin != null){
            Driver ast1 = new Driver();
            ast1.setUuid(generatePositiveUuid());
            ast1.setFirstName("Fernando");
            ast1.setLastName("Alonso");
            ast1.setAge(45);
            ast1.setRaceNumber(14);
            ast1.setTeamId(astonMartin.getId());
            ast1.setRacesEntered(404);
            ast1.setRacesWon(32);
            ast1.setPodiums(106);
            ast1.setPolePositions(22);
            ast1.setTitlesWon(2);
            driverService.addDriver(ast1);

            Driver ast2 = new Driver();
            ast2.setUuid(generatePositiveUuid());
            ast2.setFirstName("Lance");
            ast2.setLastName("Stroll");
            ast2.setAge(28);
            ast2.setRaceNumber(18);
            ast2.setTeamId(astonMartin.getId());
            ast2.setRacesEntered(170);
            ast2.setRacesWon(0);
            ast2.setPodiums(3);
            ast2.setPolePositions(1);
            ast2.setTitlesWon(0);
            driverService.addDriver(ast2);
        }

        TeamReadDTO alpine = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "BWT Alpine F1 Team"))
                .findFirst()
                .orElse(null);

        if(alpine != null){
            Driver alp1 = new Driver();
            alp1.setUuid(generatePositiveUuid());
            alp1.setFirstName("Pierre");
            alp1.setLastName("Gasly");
            alp1.setAge(30);
            alp1.setRaceNumber(10);
            alp1.setTeamId(alpine.getId());
            alp1.setRacesEntered(162);
            alp1.setRacesWon(1);
            alp1.setPodiums(5);
            alp1.setPolePositions(0);
            alp1.setTitlesWon(0);
            driverService.addDriver(alp1);

            Driver alp2 = new Driver();
            alp2.setUuid(generatePositiveUuid());
            alp2.setFirstName("Jack");
            alp2.setLastName("Doohan");
            alp2.setAge(23);
            alp2.setRaceNumber(7);
            alp2.setTeamId(alpine.getId());
            alp2.setRacesEntered(24);
            alp2.setRacesWon(0);
            alp2.setPodiums(0);
            alp2.setPolePositions(0);
            alp2.setTitlesWon(0);
            driverService.addDriver(alp2);
        }

        TeamReadDTO williams = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Williams Racing"))
                .findFirst()
                .orElse(null);

        if(williams != null){
            Driver wil1 = new Driver();
            wil1.setUuid(generatePositiveUuid());
            wil1.setFirstName("Alexander");
            wil1.setLastName("Albon");
            wil1.setAge(30);
            wil1.setRaceNumber(23);
            wil1.setTeamId(williams.getId());
            wil1.setRacesEntered(110);
            wil1.setRacesWon(0);
            wil1.setPodiums(2);
            wil1.setPolePositions(0);
            wil1.setTitlesWon(0);
            driverService.addDriver(wil1);

            Driver wil2 = new Driver();
            wil2.setUuid(generatePositiveUuid());
            wil2.setFirstName("Carlos");
            wil2.setLastName("Sainz");
            wil2.setAge(32);
            wil2.setRaceNumber(55);
            wil2.setTeamId(williams.getId());
            wil2.setRacesEntered(210);
            wil2.setRacesWon(4);
            wil2.setPodiums(26);
            wil2.setPolePositions(6);
            wil2.setTitlesWon(0);
            driverService.addDriver(wil2);
        }

        TeamReadDTO rbTeam = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Visa Cash App RB Formula One Team"))
                .findFirst()
                .orElse(null);

        if(rbTeam != null){
            Driver rb1 = new Driver();
            rb1.setUuid(generatePositiveUuid());
            rb1.setFirstName("Yuki");
            rb1.setLastName("Tsunoda");
            rb1.setAge(26);
            rb1.setRaceNumber(22);
            rb1.setTeamId(rbTeam.getId());
            rb1.setRacesEntered(92);
            rb1.setRacesWon(0);
            rb1.setPodiums(0);
            rb1.setPolePositions(0);
            rb1.setTitlesWon(0);
            driverService.addDriver(rb1);

            Driver rb2 = new Driver();
            rb2.setUuid(generatePositiveUuid());
            rb2.setFirstName("Liam");
            rb2.setLastName("Lawson");
            rb2.setAge(24);
            rb2.setRaceNumber(40);
            rb2.setTeamId(rbTeam.getId());
            rb2.setRacesEntered(30);
            rb2.setRacesWon(0);
            rb2.setPodiums(0);
            rb2.setPolePositions(0);
            rb2.setTitlesWon(0);
            driverService.addDriver(rb2);
        }

        TeamReadDTO sauber = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "Stake F1 Team Kick Sauber"))
                .findFirst()
                .orElse(null);

        if(sauber != null){
            Driver sau1 = new Driver();
            sau1.setUuid(generatePositiveUuid());
            sau1.setFirstName("Nico");
            sau1.setLastName("Hülkenberg");
            sau1.setAge(39);
            sau1.setRaceNumber(27);
            sau1.setTeamId(sauber.getId());
            sau1.setRacesEntered(245);
            sau1.setRacesWon(0);
            sau1.setPodiums(0);
            sau1.setPolePositions(1);
            sau1.setTitlesWon(0);
            driverService.addDriver(sau1);

            Driver sau2 = new Driver();
            sau2.setUuid(generatePositiveUuid());
            sau2.setFirstName("Gabriel");
            sau2.setLastName("Bortoleto");
            sau2.setAge(22);
            sau2.setRaceNumber(5);
            sau2.setTeamId(sauber.getId());
            sau2.setRacesEntered(24);
            sau2.setRacesWon(0);
            sau2.setPodiums(0);
            sau2.setPolePositions(0);
            sau2.setTitlesWon(0);
            driverService.addDriver(sau2);
        }

        TeamReadDTO haas = teams.stream()
                .filter(team -> Objects.equals(team.getName(), "MoneyGram Haas F1 Team"))
                .findFirst()
                .orElse(null);

        if(haas != null){
            Driver haa1 = new Driver();
            haa1.setUuid(generatePositiveUuid());
            haa1.setFirstName("Esteban");
            haa1.setLastName("Ocon");
            haa1.setAge(30);
            haa1.setRaceNumber(31);
            haa1.setTeamId(haas.getId());
            haa1.setRacesEntered(160);
            haa1.setRacesWon(1);
            haa1.setPodiums(4);
            haa1.setPolePositions(0);
            haa1.setTitlesWon(0);
            driverService.addDriver(haa1);

            Driver haa2 = new Driver();
            haa2.setUuid(generatePositiveUuid());
            haa2.setFirstName("Oliver");
            haa2.setLastName("Bearman");
            haa2.setAge(21);
            haa2.setRaceNumber(87);
            haa2.setTeamId(haas.getId());
            haa2.setRacesEntered(28);
            haa2.setRacesWon(0);
            haa2.setPodiums(0);
            haa2.setPolePositions(0);
            haa2.setTitlesWon(0);
            driverService.addDriver(haa2);
        }
    }
    private UUID generatePositiveUuid() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        }
        while (uuid.getMostSignificantBits() < 0 );
        return uuid;
    }
}
