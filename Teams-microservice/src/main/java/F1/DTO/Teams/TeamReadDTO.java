package F1.DTO.Teams;

import lombok.Getter;

import java.util.UUID;

@Getter
public final class TeamReadDTO {
    private final UUID id;
    private final String name;
    private final String teamLeader;
    private final int firstEntry;
    private final int championshipsWon;

    public TeamReadDTO(UUID id, String name, String teamLeader, int firstEntry, int championshipsWon) {
        this.id = id;
        this.name = name;
        this.teamLeader = teamLeader;
        this.firstEntry = firstEntry;
        this.championshipsWon = championshipsWon;
    }
}
