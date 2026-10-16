package F1.CommandLine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring initializing complete. Initializaing data....");

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.println("Welcome in F1 Driver & Teams Manager!");
            System.out.println("1. Show teams");
            System.out.println("2. Show drivers");
            System.out.println("3. Add driver");
            System.out.println("4. Delete driver");
            System.out.println("5. Exit");

            int opt = scanner.nextInt();
            switch(opt){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    run = false;
                    break;
                default:
            }
        }
    }
}
