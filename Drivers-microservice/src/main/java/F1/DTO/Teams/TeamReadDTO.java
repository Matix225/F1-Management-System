package F1.DTO.Teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.UUID;

//data about team received from Teams-microservice (GET /api/teams)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public String toString(){
        return "\n{\n"
                + " Name: " + name + "\n"
                + " First entry: " + firstEntry + "\n"
                + " Team leader: " + teamLeader + "\n"
                + " Constructor championship titles: " + championshipsWon + "\n"
                + "}\n";
    }
}
