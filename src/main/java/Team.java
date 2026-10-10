import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Team implements Comparable<Team>{
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
    public int compareTo(Team other){
        //first teams will be sort by name, then by number of championships,
        //grand prix appearance, grand prix wins and at the end by number of podiums

        //name
        if(this.name.compareTo(other.name) != 0){
            return this.name.compareTo(other.name);
        }

        //Championships
        if(Integer.compare(this.championshipsWon, other.championshipsWon) != 0){
            return Integer.compare(this.championshipsWon, other.championshipsWon);
        }

        //GP appearance
        if(Integer.compare(this.totalRaces, other.totalRaces) != 0){
            return Integer.compare(this.totalRaces, other.totalRaces);
        }

        //GP wins
        if(Integer.compare(this.racesWon, other.racesWon) != 0){
            return Integer.compare(this.racesWon, other.racesWon);
        }

        //GP podiums
        return  Integer.compare(this.podiums, other.podiums);
    };
    @Override
    public String toString(){
        return "\n{\n"
                + " Name: " + name + "\n"
                + " First entry: " + firstEntry + "\n"
                + " Country: " + country + "\n"
                + " Headquarter: " + headquarters + "\n"
                + " Team leader: " + teamLeader + "\n"
                + " Total races: " + totalRaces + "\n"
                + " Races won: " + racesWon + "\n"
                + " Podiums: " + podiums + "\n"
                + " Constructor championship titles: " + championshipsWon + "\n"
                + "}\n";
    };
}
