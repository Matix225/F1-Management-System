package F1.DTO.Drivers;

import lombok.Getter;

import java.util.UUID;

@Getter
public final class DriverReadDTO {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int raceNumber;
    private final String teamName;


    public DriverReadDTO(UUID id, String firstName, String lastName, int raceNumber, String teamName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.raceNumber = raceNumber;
        this.teamName = teamName;
    }
}
