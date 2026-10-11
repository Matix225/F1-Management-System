import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
public class Driver implements Comparable<Driver>, Serializable {
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
    public boolean equals(Object other){
        if(this == other){
            return true;
        }

        if(other instanceof Driver){
            Driver tmp = (Driver)other;
            return Objects.equals(raceNumber, tmp.raceNumber);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(raceNumber);
    }
    @Override
    public int compareTo(Driver other){
        //first drivers will be sort by grand prix appearance
        //then by podiums, grand prix wins, and at the end by first name and last name

        //GP appearance
        if(Integer.compare(this.racesEntered, other.racesEntered) != 0){
            return Integer.compare(this.racesEntered, other.racesEntered);
        }

        //Podiums achived
        if(Integer.compare(this.podiums, other.podiums) != 0){
            return Integer.compare(this.podiums, other.podiums);
        }
        //GP wins
        if(Integer.compare(this.racesWon, other.racesWon) != 0){
            return Integer.compare(this.racesWon, other.racesWon);
        }
        //First name
        if(this.firstName.compareTo(other.firstName) != 0){
            return this.firstName.compareTo(other.firstName);
        }
        //Last name
        return this.lastName.compareTo(other.lastName);
    };
    @Override
    public String toString(){

        return "{\n"
                + " Full name: " + firstName + " " + lastName + "\n"
                + " Age: " + age + "\n"
                + " Race number: " + raceNumber + "\n"
                + " Team: " + currentTeam.name + "\n"
                + " Races entered: " + racesEntered + "\n"
                + " Races won: " + racesWon + "\n"
                + " Podiums: " + podiums + "\n"
                + " Pole positions: " + polePositions + "\n"
                + " Driver championship title: " + titlesWon + "\n"
                + "}\n";
    }
}
