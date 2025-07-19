package zombieGame;
import java.util.Scanner;

public class GameEngine {
    public static void moveToNextScenario() {
        
    }

    private static void emptyLine() {
         System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        emptyLine();
        Scenario scenario1 = new Safehouse();
        System.out.println(scenario1.getDescription());
        emptyLine();
        scenario1.getChoices();
        System.out.println("Please input a number from 1 to 3");
        int choiceIndex = scan.nextInt();
        scenario1.applyChoice(choiceIndex);

    
    }
}
