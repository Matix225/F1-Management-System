package F1.DTO.Teams;

import lombok.Getter;

@Getter
public final class TeamDTO {
    //create and update data
    private final String name;
    private final String teamLeader;
    private final int firstEntry;
    private final int totalRaces;
    private final int racesWon;
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
