package zombieGame;
import java.util.Scanner;

public class GameEngine {
    public static void moveToNextScenario(int scenarioNumber) {
        switch (scenarioNumber) {
            case 1:
                safehouseGame();
                break;
            case 2:
                streetGame();
                break;
            case 3:
                garageGame();
                break;
        }
    }

    private static void emptyLine() {
         System.out.println("\n"); 
    }

    private static void safehouseGame() {
        emptyLine();
        Scenario scenario1 = new Safehouse();
        System.out.println(scenario1.getDescription());
        emptyLine();
        scenario1.getChoices();
        System.out.println("Please input a number from 1 to 3");
        Scanner scan = new Scanner(System.in);
        int choiceIndex = scan.nextInt();
        scenario1.applyChoice(choiceIndex);
    }

    private static void streetGame() {
        emptyLine();
        Scenario scenario2 = new Street();
        System.out.println(scenario2.getDescription());
        emptyLine();
        scenario2.getChoices();
        System.out.println("Please input a number from 1 to 2");
        Scanner scan = new Scanner(System.in);
        int choiceIndex = scan.nextInt();
        scenario2.applyChoice(choiceIndex);
    }

     private static void garageGame() {
        emptyLine();
        Scenario scenario3 = new Garage();
        System.out.println(scenario3.getDescription());
        emptyLine();
        scenario3.getChoices();
        System.out.println("Please input a number from 1 to 3");
        Scanner scan = new Scanner(System.in);
        int choiceIndex = scan.nextInt();
        scenario3.applyChoice(choiceIndex);
    }

    public static void main(String[] args) {
        new Backpack();
        new Player();
        emptyLine();
        moveToNextScenario(1);

    }
}
