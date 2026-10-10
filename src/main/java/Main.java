import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(){
        List<Team> teamsList = new ArrayList<>();

        Team redBull = Team.builder()
                .name("Oracle Red Bull Racing")
                .firstEntry(2005)
                .country("Austria")
                .headquarters("Milton Keynes")
                .teamLeader("Laurent Mekies")
                .totalRaces(434)
                .racesWon(131)
                .podiums(242)
                .championshipsWon(6)
                .build();
        redBull.setDrivers(redBullDrivers(redBull));
        teamsList.add(redBull);

        Team mercedes = Team.builder()
                .name("Mercedes AMG Petronas Formula One Team")
                .firstEntry(1970)
                .country("Germany")
                .headquarters("Brackley")
                .teamLeader("Toto Wolff")
                .totalRaces(345)
                .racesWon(133)
                .podiums(217)
                .championshipsWon(8)
                .build();
        mercedes.setDrivers(mercedesDrivers(mercedes));
        teamsList.add(mercedes);

        /*Set<Driver> drivers = createDriversSet(teamsList);
        System.out.print(drivers.toString());*/
    }

    //functions initializing program data using Builder pattern from Lombok library
    private static List<Driver> redBullDrivers(Team team){
        Driver red1 = Driver.builder()
                .firstName("Max")
                .lastName("Verstappen")
                .age(29)
                .raceNumber(3)
                .currentTeam(team)
                .racesEntered(249)
                .racesWon(72)
                .podiums(135)
                .polePositions(49)
                .titlesWon(4)
                .build();
        Driver red2 = Driver.builder()
                .firstName("Isac")
                .lastName("Hadjar")
                .age(29)
                .raceNumber(6)
                .currentTeam(team)
                .racesEntered(36)
                .racesWon(0)
                .podiums(3)
                .polePositions(0)
                .titlesWon(0)
                .build();
        List<Driver> tmp = new ArrayList<>();
        tmp.add(red1);
        tmp.add(red2);

        return tmp;
    }
    private static List<Driver> mercedesDrivers(Team team){
        Driver mer1 = Driver.builder()
                .firstName("George")
                .lastName("Russell")
                .age(29)
                .currentTeam(team)
                .raceNumber(63)
                .racesEntered(168)
                .racesWon(8)
                .podiums(32)
                .polePositions(13)
                .titlesWon(0)
                .build();
        Driver mer2 = Driver.builder()
                .firstName("Kimi")
                .lastName("Antonelli")
                .age(18)
                .currentTeam(team)
                .raceNumber(12)
                .racesEntered(40)
                .racesWon(8)
                .podiums(16)
                .polePositions(6)
                .titlesWon(0)
                .build();
        List<Driver> tmp = new ArrayList<>();
        tmp.add(mer1);
        tmp.add(mer2);

        return tmp;
    }

    //function that creates set of drivers using Stream API
    private static Set<Driver> createDriversSet(List<Team> teams){
        Set<Driver> drivers = teams.stream()
                .flatMap(team -> team.getDrivers().stream())
                .collect(Collectors.toSet());
        return drivers;
    };
}
