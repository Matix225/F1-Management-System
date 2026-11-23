package F1.Utils;

import F1.Entities.Team;
import F1.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final TeamService teamService;

    @Autowired
    public DataInitializer(TeamService teamService){
        this.teamService = teamService;
    }

    public void initData(){
        initTeams();
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
    private UUID generatePositiveUuid() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        }
        while (uuid.getMostSignificantBits() < 0 );
        return uuid;
    }
}
