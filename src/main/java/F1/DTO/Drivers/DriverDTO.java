package F1.DTO.Drivers;

import lombok.Getter;

@Getter
public final class DriverDTO {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int raceNumber;
    private final int racesEntered;
    private final int racesWon;
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
