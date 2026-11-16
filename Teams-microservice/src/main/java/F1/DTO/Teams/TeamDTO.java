package F1.DTO.Teams;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public final class TeamDTO {
    //create and update data
    @NotBlank(message = "Team must have a name!")
    @Size(max = 50, message = "Maximum length of team name is 50!")
    private final String name;
    private final String teamLeader;
    @Min(value = 1950, message = "Minimum value of firstEntry is 1950!")
    private final int firstEntry;
    @Min(value = 0, message = "Minimum value of totalRaces is 0!")
    private final int totalRaces;
    @Min(value = 0, message = "Minimum value of racesWon is 0!")
    private final int racesWon;
    @Min(value = 0, message = "Minimum value of championshipsWon is 0!")
    private final int championshipsWon;

    public TeamDTO(String name, String teamLeader, int firstEntry, int totalRaces, int racesWon, int championshipsWon) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.firstEntry = firstEntry;
        this.totalRaces = totalRaces;
        this.racesWon = racesWon;
        this.championshipsWon = championshipsWon;
    }
}
