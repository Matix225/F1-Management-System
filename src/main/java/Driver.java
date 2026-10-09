public class Driver {
    String firstName;
    String lastName;
    int age;
    Team currentTeam;

    int racesWon;
    int polePositions;
    int titles;

    public Driver(String firstName, String lastName, int age, Team currentTeam, int racesWon, int polePositions, int titles){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.currentTeam = currentTeam;
        this.racesWon = racesWon;
        this.polePositions = polePositions; // Zwróć uwagę na literówkę w oryginalnym argumencie (polePosition vs polePositions)
        this.titles = titles;
    }

    @Override
    public String toString(){
        return "{\n"
                + " Full name: " + firstName + " " + lastName + "\n"
                + " Age: " + age + "\n"
                + " Races won: " + racesWon + "\n"
                + " Pole positions: " + polePositions + "\n"
                + " Driver championships: " + titles + "\n"
                + "}\n";
    }
}
