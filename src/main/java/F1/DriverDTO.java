package F1;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class DriverDTO implements Comparable<DriverDTO>{
    String firstName;
    String lastName;
    int age;
    int raceNumber;
    String teamName;

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

        if(other instanceof DriverDTO){
            DriverDTO tmp = (DriverDTO)other;
            return Objects.equals(raceNumber, tmp.raceNumber);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(raceNumber);
    }
    @Override
    public int compareTo(DriverDTO other){
        //first drivers will be sort by first name and last name
        //then by grand prix appearance, podiums, and at the end by grand prix wins

        //First name
        if(this.firstName.compareTo(other.firstName) != 0){
            return this.firstName.compareTo(other.firstName);
        }
        //Last name
        if(this.lastName.compareTo(other.lastName) != 0){
            return this.lastName.compareTo(other.lastName);
        }
        //F1.Team name
        if(this.teamName.compareTo(other.teamName) != 0){
            return this.teamName.compareTo(other.teamName);
        }
        //GP appearance
        if(Integer.compare(this.racesEntered, other.racesEntered) != 0){
            return Integer.compare(this.racesEntered, other.racesEntered);
        }
        //Podiums
        if(Integer.compare(this.podiums, other.podiums) != 0){
            return Integer.compare(this.podiums, other.podiums);
        }
        //GP wins
        return Integer.compare(this.racesWon, other.racesWon);
    };
    @Override
    public String toString(){
        return "{\n"
                + " Full name: " + firstName + " " + lastName + "\n"
                + " Age: " + age + "\n"
                + " Race number: " + raceNumber + "\n"
                + " F1.Team: " + teamName + "\n"
                + " Races entered: " + racesEntered + "\n"
                + " Races won: " + racesWon + "\n"
                + " Podiums: " + podiums + "\n"
                + " Pole positions: " + polePositions + "\n"
                + " F1.Driver championship title: " + titlesWon + "\n"
                + "}\n";
    }
}
