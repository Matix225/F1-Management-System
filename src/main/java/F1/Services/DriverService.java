package F1.Services;

import F1.Entities.Driver;
import F1.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }
    public Driver getDriverByRaceNumber(int raceNumber){
        return driverRepository.findDriverByRaceNumber(raceNumber);
    }
    public void addDriver(Driver driver){
        //input validation
        if(driver.getFirstName() == null || driver.getLastName() == null){
            System.out.println("You have to enter name and last name!");
            return;
        }

        //name and lastName should only consist of characters
        String name = driver.getFirstName(), lastName = driver.getLastName();
        if(name.chars().anyMatch(Character::isDigit)){
            System.out.println("Name can only consist letters");
            return;
        }

        if(name.chars().anyMatch(Character::isDigit)){
            System.out.println("Name can only consist letters");
            return;
        }
        if(lastName.chars().anyMatch(Character::isDigit)){
            System.out.println("Name can only consist letters");
            return ;
        }

        //race numbers should be in range from 2 to 99. Current champion can use number 1.
        int raceNumber = driver.getRaceNumber();
        if((raceNumber < 2) || (raceNumber > 99)){
            System.out.println("Race number should be a number from 2 to 99!");
            return;
        }
        //check if other driver already have this number
        if(getDriverByRaceNumber(raceNumber) != null){
            System.out.println("Race number already taken. Choose different!");
            return;
        }

        driverRepository.save(driver);
        System.out.println("Driver added successfully!");
    }
    public void deleteDriver(int raceNumber){
        Driver driver = driverRepository.findDriverByRaceNumber(raceNumber);
        if(driver == null){
            System.out.println("Race number is not assign to any driver!");
            return;
        }

        driverRepository.delete(driver);
        System.out.println("Driver deleted successfully!");
    }
}
