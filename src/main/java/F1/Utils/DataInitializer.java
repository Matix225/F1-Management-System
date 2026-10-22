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
        redBull.setUuid(generatePositiveUuid());
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
        mercedes.setUuid(generatePositiveUuid());
        mercedes.setName("Mercedes-AMG Petronas Formula One Team");
        mercedes.setFirstEntry(1970);
        mercedes.setCountry("Germany");
        mercedes.setHeadquarters("Brackley");
        mercedes.setTeamLeader("Toto Wolff");
        mercedes.setTotalRaces(345);
        mercedes.setRacesWon(133);
        mercedes.setPodiums(217);
        mercedes.setChampionshipsWon(8);
        teamService.addTeam(mercedes);

        Team ferrari = new Team();
        ferrari.setUuid(generatePositiveUuid());
        ferrari.setName("Scuderia Ferrari HP");
        ferrari.setFirstEntry(1950);
        ferrari.setCountry("Italy");
        ferrari.setHeadquarters("Maranello");
        ferrari.setTeamLeader("Frédéric Vasseur");
        ferrari.setTotalRaces(1120);
        ferrari.setRacesWon(252);
        ferrari.setPodiums(820);
        ferrari.setChampionshipsWon(16);
        teamService.addTeam(ferrari);

        Team mclaren = new Team();
        mclaren.setUuid(generatePositiveUuid());
        mclaren.setName("McLaren Formula 1 Team");
        mclaren.setFirstEntry(1966);
        mclaren.setCountry("United Kingdom");
        mclaren.setHeadquarters("Woking");
        mclaren.setTeamLeader("Zak Brown");
        mclaren.setTotalRaces(1006);
        mclaren.setRacesWon(192);
        mclaren.setPodiums(534);
        mclaren.setChampionshipsWon(9);
        teamService.addTeam(mclaren);

        Team astonMartin = new Team();
        astonMartin.setUuid(generatePositiveUuid());
        astonMartin.setName("Aston Martin Aramco Formula One Team");
        astonMartin.setFirstEntry(2018);
        astonMartin.setCountry("United Kingdom");
        astonMartin.setHeadquarters("Silverstone");
        astonMartin.setTeamLeader("Andy Cowell");
        astonMartin.setTotalRaces(112);
        astonMartin.setRacesWon(1);
        astonMartin.setPodiums(10);
        astonMartin.setChampionshipsWon(0);
        teamService.addTeam(astonMartin);

        Team alpine = new Team();
        alpine.setUuid(generatePositiveUuid());
        alpine.setName("BWT Alpine F1 Team");
        alpine.setFirstEntry(1986);
        alpine.setCountry("France");
        alpine.setHeadquarters("Enstone");
        alpine.setTeamLeader("Flavio Briatore");
        alpine.setTotalRaces(460);
        alpine.setRacesWon(21);
        alpine.setPodiums(107);
        alpine.setChampionshipsWon(2);
        teamService.addTeam(alpine);

        Team williams = new Team();
        williams.setUuid(generatePositiveUuid());
        williams.setName("Williams Racing");
        williams.setFirstEntry(1978);
        williams.setCountry("United Kingdom");
        williams.setHeadquarters("Grove");
        williams.setTeamLeader("James Vowles");
        williams.setTotalRaces(834);
        williams.setRacesWon(114);
        williams.setPodiums(313);
        williams.setChampionshipsWon(9);
        teamService.addTeam(williams);

        Team rb = new Team();
        rb.setUuid(generatePositiveUuid());
        rb.setName("Visa Cash App RB Formula One Team");
        rb.setFirstEntry(2006);
        rb.setCountry("Italy");
        rb.setHeadquarters("Faenza");
        rb.setTeamLeader("Peter Bayer");
        rb.setTotalRaces(382);
        rb.setRacesWon(2);
        rb.setPodiums(5);
        rb.setChampionshipsWon(0);
        teamService.addTeam(rb);

        Team sauber = new Team();
        sauber.setUuid(generatePositiveUuid());
        sauber.setName("Stake F1 Team Kick Sauber");
        sauber.setFirstEntry(1993);
        sauber.setCountry("Switzerland");
        sauber.setHeadquarters("Hinwil");
        sauber.setTeamLeader("Mattia Binotto");
        sauber.setTotalRaces(624);
        sauber.setRacesWon(1);
        sauber.setPodiums(27);
        sauber.setChampionshipsWon(0);
        teamService.addTeam(sauber);

        Team haas = new Team();
        haas.setUuid(generatePositiveUuid());
        haas.setName("MoneyGram Haas F1 Team");
        haas.setFirstEntry(2016);
        haas.setCountry("United States");
        haas.setHeadquarters("Kannapolis");
        haas.setTeamLeader("Ayao Komatsu");
        haas.setTotalRaces(205);
        haas.setRacesWon(0);
        haas.setPodiums(0);
        haas.setChampionshipsWon(0);
        teamService.addTeam(haas);
    }
    public void initDrivers(){
        List<Team> teams = teamService.getAllTeams();

        Team redBull = teams.stream()
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
            red1.setCurrentTeam(redBull);
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
            red2.setCurrentTeam(redBull);
            red2.setRacesEntered(36);
            red2.setRacesWon(0);
            red2.setPodiums(3);
            red2.setPolePositions(0);
            red2.setTitlesWon(0);
            driverService.addDriver(red2);
        }

        Team mercedes = teams.stream()
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
            mer1.setCurrentTeam(mercedes);
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
            mer2.setCurrentTeam(mercedes);
            mer2.setRacesEntered(40);
            mer2.setRacesWon(8);
            mer2.setPodiums(16);
            mer2.setPolePositions(6);
            mer2.setTitlesWon(0);
            driverService.addDriver(mer2);
        }

        Team ferrari = teams.stream()
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
            fer1.setCurrentTeam(ferrari);
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
            fer2.setCurrentTeam(ferrari);
            fer2.setRacesEntered(356);
            fer2.setRacesWon(105);
            fer2.setPodiums(201);
            fer2.setPolePositions(104);
            fer2.setTitlesWon(7);
            driverService.addDriver(fer2);
        }

        Team mclaren = teams.stream()
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
            mcl1.setCurrentTeam(mclaren);
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
            mcl2.setCurrentTeam(mclaren);
            mcl2.setRacesEntered(68);
            mcl2.setRacesWon(5);
            mcl2.setPodiums(22);
            mcl2.setPolePositions(2);
            mcl2.setTitlesWon(0);
            driverService.addDriver(mcl2);
        }

        Team astonMartin = teams.stream()
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
            ast1.setCurrentTeam(astonMartin);
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
            ast2.setCurrentTeam(astonMartin);
            ast2.setRacesEntered(170);
            ast2.setRacesWon(0);
            ast2.setPodiums(3);
            ast2.setPolePositions(1);
            ast2.setTitlesWon(0);
            driverService.addDriver(ast2);
        }

        Team alpine = teams.stream()
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
            alp1.setCurrentTeam(alpine);
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
            alp2.setCurrentTeam(alpine);
            alp2.setRacesEntered(24);
            alp2.setRacesWon(0);
            alp2.setPodiums(0);
            alp2.setPolePositions(0);
            alp2.setTitlesWon(0);
            driverService.addDriver(alp2);
        }

        Team williams = teams.stream()
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
            wil1.setCurrentTeam(williams);
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
            wil2.setCurrentTeam(williams);
            wil2.setRacesEntered(210);
            wil2.setRacesWon(4);
            wil2.setPodiums(26);
            wil2.setPolePositions(6);
            wil2.setTitlesWon(0);
            driverService.addDriver(wil2);
        }

        Team rbTeam = teams.stream()
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
            rb1.setCurrentTeam(rbTeam);
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
            rb2.setCurrentTeam(rbTeam);
            rb2.setRacesEntered(30);
            rb2.setRacesWon(0);
            rb2.setPodiums(0);
            rb2.setPolePositions(0);
            rb2.setTitlesWon(0);
            driverService.addDriver(rb2);
        }

        Team sauber = teams.stream()
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
            sau1.setCurrentTeam(sauber);
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
            sau2.setCurrentTeam(sauber);
            sau2.setRacesEntered(24);
            sau2.setRacesWon(0);
            sau2.setPodiums(0);
            sau2.setPolePositions(0);
            sau2.setTitlesWon(0);
            driverService.addDriver(sau2);
        }

        Team haas = teams.stream()
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
            haa1.setCurrentTeam(haas);
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
            haa2.setCurrentTeam(haas);
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
