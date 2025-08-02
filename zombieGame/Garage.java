package zombieGame;

import java.util.Scanner;

public class Garage implements Scenario {

    String[] choiceSet1;

    public Garage() {
        choiceSet1 = new String[3];
        choiceSet1[0] = "1. [Placeholder] Check the left side of the garage";
        choiceSet1[1] = "2. [Placeholder] Approach the workbench";
        choiceSet1[2] = "3. [Placeholder] Inspect the lockers";
    }

    @Override
    public String getDescription() {
        return "Jason steps into the garage, his boots echoing on the oil-stained concrete floor.\n"
             + "A single fluorescent light flickers overhead, casting sharp shadows between the rows of abandoned vehicles.\n"
             + "Near the back, he spots a military-grade SUV—its reinforced frame still intact.\n"
             + "He swings open the driver’s door and checks the ignition.\n"
             + "Nothing. The dashboard stays dark.\n"
             + "Jason pops the hood and mutters under his breath.\n"
             + "The battery is missing.\n"
             + "Without it, the vehicle is just dead weight.\n"
             + "He closes the hood slowly and looks around the dim garage. He’ll have to find a replacement somewhere in here.";
    }

    @Override
    public void getChoices() {
        for (int index = 0; index < choiceSet1.length; index++) {
            if (choiceSet1[index] != null) {
                System.out.println(choiceSet1[index]);
            }
        }
    }

    @Override
    public void applyChoice(int choiceIndex) {
        switch (choiceIndex) {
            case 1:
                Choice1();
                break;
            case 2:
                Choice2();
                break;
            case 3:
                Choice3();
                break;
            default:
                System.out.println("Please input a number from 1 to 3.");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                applyChoice(choice);
        }
    }

    public void Choice1() {
        System.out.println("[Placeholder] Jason explores the left side of the garage...");
        // To be implemented with actual puzzle logic
    }

    public void Choice2() {
        System.out.println("[Placeholder] Jason approaches the cluttered workbench...");
        // To be implemented with clues or tools
    }

    public void Choice3() {
        System.out.println("[Placeholder] Jason checks the lockers lined up in the back...");
        // To be implemented with puzzle, key, or jump scare
    }
}
