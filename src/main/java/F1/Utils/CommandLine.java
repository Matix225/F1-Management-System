package F1.Utils;

import F1.Entities.Driver;
import F1.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    private final DriverService driverService;
    private final Scanner scanner;
    private boolean run = true;

    @Autowired
    public CommandLine(DriverService driverService){
        this.scanner = new Scanner(System.in);

        this.driverService = driverService;
        //this.teamService = teamService;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring initializing complete. Initializaing data....");

        while(run){
            System.out.println("Welcome in F1 Driver & Teams Manager!");
            System.out.println("1. Show teams");
            System.out.println("2. Show drivers");
            System.out.println("3. Add driver");
            System.out.println("4. Delete driver");
            System.out.println("5. Exit");

            int opt = scanner.nextInt();
            switch(opt){
                case 1:
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

    public void showDrivers(){
        List<Driver> drivers = driverService.getAllDrivers();
        if(drivers == null){
            System.out.println("No drivers available!");
        }

        drivers.forEach(System.out::println);
    }
    public void addDriver(){
        //collect input about drivers then send it to repo
        //for saving and verifying new driver data

        System.out.println("Enter driver name: ");
        String name = scanner.nextLine();

        System.out.println("Enter driver last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter driver race number: ");
        int raceNumber = scanner.nextInt();

        Driver driver = new Driver();
        driver.setFirstName(name);
        driver.setLastName(lastName);
        driver.setRaceNumber(raceNumber);

        driverService.addDriver(driver);
    }
    public void deleteDriver(){
        System.out.println("Enter driver race number: ");
        int raceNumber = scanner.nextInt();

        driverService.deleteDriver(raceNumber);
    }
}
