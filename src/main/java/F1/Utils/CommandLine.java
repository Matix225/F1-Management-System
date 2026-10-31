package F1.Utils;

import F1.Entities.Driver;
import F1.Entities.Team;
import F1.Services.DriverService;
import F1.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandLine implements CommandLineRunner {
    private final DriverService driverService;
    private final TeamService teamService;
    private final DataInitializer dataInitializer;
    private final Scanner scanner;
    private final String[] validationMessage = {
            "Everything is fine. Adding driver...",
            "Name can't be empty!",
            "Last name can't be empty!",
            "Driver must be assign to an existing team!",
            "Race number already taken!",
            "Race number should be in range 1 to 99!",
            "Name should only consist of letters!",
            "Last name should only consist of letters!",
    };

    @Autowired
    public CommandLine(DriverService driverService, TeamService teamService, DataInitializer dataInitializer){
        this.scanner = new Scanner(System.in);

        this.driverService = driverService;
        this.teamService = teamService;
        this.dataInitializer = dataInitializer;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring initializing complete. Initializaing data....");
        dataInitializer.initData();

        System.out.println("Initialization complete!");
        System.out.println();
        boolean run = true;
        while(run){
            System.out.println("Welcome in F1 Driver & Teams Manager!");
            System.out.println("1. Show teams");
            System.out.println("2. Show drivers");
            System.out.println("3. Add driver");
            System.out.println("4. Delete driver");
            System.out.println("5. Exit");

            int opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    showTeams();
                    break;
                case 2:
                    showDrivers();
                    break;
                case 3:
                    addDriver();
                    break;
                case 4:
                    deleteDriver();
                    break;
                case 5:
                    run = false;
                    break;
                default:
            }
        }
    }

    public void showTeams(){
        List<Team> teams = teamService.getAllTeams();
        if(teams == null){
            System.out.println("No teams available!");
        }

        teams.forEach(System.out::println);
    }
    public void showDrivers(){
        List<Driver> drivers = driverService.getAllDrivers();
        if(drivers == null){
            System.out.println("No drivers available!");
        }

        drivers.forEach(System.out::println);
    }
    public void addDriver(){//function that allows user to add new driver to the database
        Driver driver = new Driver();

        System.out.println("Enter driver name: ");
        driver.setFirstName(scanner.nextLine());

        System.out.println("Enter driver last name: ");
        driver.setLastName(scanner.nextLine());

        System.out.println("Enter driver race number: ");
        driver.setRaceNumber(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine();
        driver.setCurrentTeam(teamService.getTeamByName(teamName));

        boolean checking = true;
        while(checking){
            //if any error appears appropriate error message will be displayed
            //and user wil be asked to enter field value again
            int errCode = driverService.verifyDriverInput(driver);
            switch(errCode){
                case 0:
                    System.out.println(validationMessage[0]);
                    checking = false;
                    break;
                case 1:
                    System.out.println(validationMessage[1]);
                    System.out.println("Enter driver name: ");
                    driver.setFirstName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println(validationMessage[2]);
                    System.out.println("Enter driver last name: ");
                    driver.setLastName(scanner.nextLine());
                    break;
                case 3:
                    System.out.println(validationMessage[3]);
                    System.out.println("Enter team name: ");
                    teamName = scanner.nextLine();
                    driver.setCurrentTeam(teamService.getTeamByName(teamName));
                    break;
                case 4:
                    System.out.println(validationMessage[4]);
                    System.out.println("Enter driver race number: ");
                    driver.setRaceNumber(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.println(validationMessage[5]);
                    System.out.println("Enter driver race number: ");
                    driver.setRaceNumber(Integer.parseInt(scanner.nextLine()));
                    break;
                case 6:
                    System.out.println(validationMessage[6]);
                    System.out.println("Enter driver name: ");
                    driver.setFirstName(scanner.nextLine());
                    break;
                case 7:
                    System.out.println(validationMessage[7]);
                    System.out.println("Enter driver last name: ");
                    driver.setLastName(scanner.nextLine());
                    break;
            }
        }

        driverService.addDriver(driver);
    }
    public void deleteDriver(){
        System.out.println("Enter driver race number: ");
        int raceNumber = scanner.nextInt();

        driverService.deleteDriver(raceNumber);
    }
}
