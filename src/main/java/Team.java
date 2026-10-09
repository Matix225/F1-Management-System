import java.util.List;
import lombok.Builder;

@Builder
public class Team{
    String name;
    int firstEntry;
    String country;
    String headquarters;
    String teamLeader;

    int totalRaces;
    int racesWon;
    int podiums;
    int championshipsWon;

    List<Driver> drivers;


    @Override
    public String toString(){
        return "";
    };
}
