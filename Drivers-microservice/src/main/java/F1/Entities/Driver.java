package F1.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "driver")
public class Driver implements Comparable<Driver>, Serializable {
    @Id
    private UUID uuid;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "raceNumber", nullable = false, unique = true)
    private int raceNumber;

    @Column(name = "racesEntered")
    private int racesEntered;

    @Column(name = "racesWon")
    private int racesWon;

    @Column(name = "podiums")
    private int podiums;

    @Column(name = "polePositions")
    private int polePositions;

    @Column(name = "titlesWon")
    private int titlesWon;

    //team lives in Teams-microservice, here only its id is kept
    @Column(name = "team_id")
    private UUID teamId;

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
                + " Team id: " + teamId + "\n"
                + " Races entered: " + racesEntered + "\n"
                + " Races won: " + racesWon + "\n"
                + " Podiums: " + podiums + "\n"
                + " Pole positions: " + polePositions + "\n"
                + " Driver championship title: " + titlesWon + "\n"
                + "}\n";
    }
}
