package F1.Services;

import F1.Entities.Driver;
import F1.Repositories.DriverRepository;
import F1.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public int verifyDriverInput(Driver driver){
        //function that verify if created driver is valid
        //return error code if it's invalid or 0 if everything is fine and
        //driver was added to the database

        //check if name is empty
        if(driver.getFirstName().isEmpty()){
            return 1;
        }
        if(driver.getLastName().isEmpty()){
            return 2;
        }
        if(driver.getCurrentTeam() == null){
            return 3;
        }
        if(driverRepository.findDriverByRaceNumber(driver.getRaceNumber()) != null){
            return 4;
        }
        if(driver.getRaceNumber() < 1 || driver.getRaceNumber() > 99){
            return 5;
        }
        if(driver.getFirstName().chars().anyMatch(Character::isWhitespace) || driver.getFirstName().chars().anyMatch(Character::isDigit)){
            return 6;
        }
        if(driver.getFirstName().chars().anyMatch(Character::isWhitespace) || driver.getFirstName().chars().anyMatch(Character::isDigit)){
            return 7;
        }

        return 0;
    }
    public void addDriver(Driver driver){
        driver.setUuid(UUID.randomUUID());
        driverRepository.save(driver);
        System.out.println("Driver added!");
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
