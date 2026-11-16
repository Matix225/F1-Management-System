package F1.Utils;

import F1.Entities.Team;
import F1.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineTeams implements CommandLineRunner {
    private final TeamService teamService;
    private final DataInitializer dataInitializer;
    private final Scanner scanner;

    @Autowired
    public CommandLineTeams(TeamService teamService, DataInitializer dataInitializer){
        this.scanner = new Scanner(System.in);

        this.teamService = teamService;
        this.dataInitializer = dataInitializer;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring initializing complete. Initializaing data....");
        dataInitializer.initData();

        System.out.println("Initialization complete!");
        System.out.println();
        boolean run = true;
        while(run){
            System.out.println("Welcome in F1 Teams Manager!");
            System.out.println("1. Show teams");
            System.out.println("2. Exit");

            int opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    showTeams();
                    break;
                case 2:
                    run = false;
                    break;
                default:
            }
        }
    }

    public void showTeams(){
        List<Team> teams = teamService.getAllTeams();
        if(teams == null){
            System.out.println("No teams available!");
        }

        teams.forEach(System.out::println);
    }
}
