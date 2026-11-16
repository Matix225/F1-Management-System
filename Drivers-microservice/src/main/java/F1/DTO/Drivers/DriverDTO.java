package F1.DTO.Drivers;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public final class DriverDTO {
    //dto for creating and updating data
    @NotBlank(message = "First name filed cannot be empty!")
    @Size(max = 50, message = "First name can only contains 50 letters!")
    private final String firstName;
    @NotBlank(message = "Last name filed cannot be empty!")
    @Size(max = 50, message = "Last name can only contains 50 letters!")
    private final String lastName;
    @Min(value = 16, message = "Minimal age is 16!")
    private final int age;
    @Min(value = 1, message = "Minimum value of race number is 0!")
    @Max(value = 99, message = "Maximum value of race number is 99!")
    private final int raceNumber;
    @Min(value = 0, message = "Minimum value of races entered is 0!")
    private final int racesEntered;
    @Min(value = 0, message = "Minimum races won is 0!")
    private final int racesWon;
    @Min(value = 0, message = "Minimum titles won is 0!")
    private final int titlesWon;

    public DriverDTO(String firstName, String lastName, int age, int raceNumber, int racesEntered, int racesWon, int titlesWon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.raceNumber = raceNumber;
        this.racesEntered = racesEntered;
        this.racesWon = racesWon;
        this.titlesWon = titlesWon;
    }
}
