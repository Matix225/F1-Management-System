import lombok.Builder;

@Builder
public class Driver {
    String firstName;
    String lastName;
    int age;
    int raceNumber;
    Team currentTeam;

    int racesEntered;
    int racesWon;
    int podiums;
    int polePositions;
    int titlesWon;

    @Override
    public String toString(){
        return "";
    }
}
