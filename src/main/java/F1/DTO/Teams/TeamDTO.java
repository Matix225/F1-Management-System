package F1.DTO.Teams;

import lombok.Getter;

@Getter
public final class TeamDTO {
    //create and update data
    private final String name;
    private final String teamLeader;
    private final int racesEntered;
    private final int racesWon;
    private final int championshipsWon;

    public TeamDTO(String name, String teamLeader, int racesEntered, int racesWon, int championshipsWon) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.racesEntered = racesEntered;
        this.racesWon = racesWon;
        this.championshipsWon = championshipsWon;
    }
}
