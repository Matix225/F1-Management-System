package F1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*public class Main {
    public static final int numberOfTeams = 2;

    /*public static void main(){
        List<F1.Team> teamsList = new ArrayList<>();

        F1.Team redBull = F1.Team.builder()
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

        F1.Team mercedes = F1.Team.builder()
                .name("Mercedes AMG Petronas Formula One F1.Team")
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

        teamsList.forEach(team -> {
                System.out.print(team.toString());
                team.getDrivers().forEach(System.out::println);
            }
        );

        Set<F1.Driver> drivers = createDriversSet(teamsList);
        //drivers.stream().forEach(System.out::println);

        //filter(drivers);

        List<F1.DriverDTO> driverDTOS = transformIntoDTO(drivers);
        //driverDTOS.stream().forEach(System.out::println);

        //data serialization and deserialization
        //writeToFile(teamsList);
        //readFromFile();


        //create paralel pipelines to calculate avg win rate for drivers which complete at least 100 Grand Prix
        try(ForkJoinPool threadPool = new ForkJoinPool(2)){
            Runnable task = () -> {
                teamsList.parallelStream()
                        .filter(team -> team.getTotalRaces() >= 210)
                        .forEach(team -> {
                            System.out.println(team.getName());
                            team.getDrivers().stream()
                                    .filter(driver -> driver.getRacesEntered() >= 100)
                                    .forEach(driver -> {
                                        try {
                                            Thread.sleep(300);
                                        }
                                        catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.println("Full name: " + driver.getFirstName() + " " + driver.getLastName());
                                        System.out.println("GP entered: " + driver.getRacesEntered() + "\n");
                                        System.out.println("Win rate: " + ((double)driver.getRacesWon() / driver.getRacesEntered()) * 100 + "\n");
                                    });
                        });
            };

            threadPool.submit(task).join();
            threadPool.shutdown();
        }
        catch(IllegalArgumentException e){
        }

    }

    //functions initializing program data using Builder pattern from Lombok library
    /*private static List<F1.Driver> redBullDrivers(F1.Team team){
        F1.Driver red1 = F1.Driver.builder()
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
        F1.Driver red2 = F1.Driver.builder()
                .firstName("Isac")
                .lastName("Hadjar")
                .age(22)
                .raceNumber(6)
                .currentTeam(team)
                .racesEntered(36)
                .racesWon(0)
                .podiums(3)
                .polePositions(0)
                .titlesWon(0)
                .build();
        List<F1.Driver> tmp = new ArrayList<>();
        tmp.add(red1);
        tmp.add(red2);

        return tmp;
    }
    private static List<F1.Driver> mercedesDrivers(F1.Team team){
        F1.Driver mer1 = F1.Driver.builder()
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
        F1.Driver mer2 = F1.Driver.builder()
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
        List<F1.Driver> tmp = new ArrayList<>();
        tmp.add(mer1);
        tmp.add(mer2);

        return tmp;
    }*/

    /*private static Set<F1.Driver> createDriversSet(List<F1.Team> teams){
        //function that creates set of drivers using Stream API
        Set<F1.Driver> drivers = teams.stream()
                .flatMap(team -> team.getDrivers().stream())
                .collect(Collectors.toSet());
        return drivers;
    };
    private static void filter(Set<F1.Driver> drivers){
        drivers.stream()
                .filter(driver -> "Mercedes AMG Petronas Formula One F1.Team".equals(driver.getCurrentTeam().getName()))
                .sorted(Comparator.comparingInt(F1.Driver::getAge))
                .forEach(System.out::println);
    }*/
    /*public static List<F1.DriverDTO> transformIntoDTO(Set<F1.Driver> allDrivers){
        //function that transform F1.Driver class objects into their DTO class
        List<F1.DriverDTO> driverDTOList = allDrivers.stream()
                .map(driver -> F1.DriverDTO.builder()
                        .firstName(driver.getFirstName())
                        .lastName(driver.getLastName()).
                        age(driver.getAge()).
                        raceNumber(driver.getRaceNumber()).
                        teamName(driver.getCurrentTeam().getName()).
                        racesEntered(driver.getRacesEntered()).
                        racesWon(driver.getRacesWon()).
                        podiums(driver.getPodiums()).
                        polePositions(driver.getPolePositions()).
                        titlesWon(driver.getTitlesWon()).
                        build()
                )
                .sorted()
                .collect(Collectors.toList());
        return driverDTOList;
    }

    //data serialization
    public static void writeToFile(List<F1.Team> teams){
        String fileName = "Data.ser";
        try(FileOutputStream file = new FileOutputStream(fileName)){
            ObjectOutputStream stream = new ObjectOutputStream(file);

            for (F1.Team team : teams) {
                stream.writeObject(team);
            }
            System.out.println("Serialization complete!");
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    //data deserialization
    public static void readFromFile(){
        String fileName = "Data.ser";
        try(FileInputStream file = new FileInputStream(fileName)){
            ObjectInputStream stream = new ObjectInputStream(file);

            List<F1.Team> teams = new ArrayList<>();
            for(int i = 0; i < numberOfTeams; i++){
                F1.Team newTeam = (F1.Team)stream.readObject();
                teams.add(newTeam);
            }

            System.out.println("Deserialization complete!");
            teams.forEach(team-> {
                System.out.println(team.toString());
                team.getDrivers().forEach(System.out::println);
            });
        }
        catch(IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/
//}



@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}