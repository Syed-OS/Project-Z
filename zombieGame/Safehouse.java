package zombieGame;
import java.util.Scanner;

/**
 * The Safehouse class represents a scenario in the game
 * where the player starts in a damaged safehouse with limited supplies.
 * 
 * @author Syed Mahir Ahamed
 */

public class Safehouse implements Scenario {

    String[] choices;

    /**
     * Constructs the Safehouse scenario and initializes the choices.
     */
    public Safehouse() {
        choices = new String[3];
        choices[0] = "1. Inspect remaining food";
        choices[1] = "2. Craft an escape plan";
        choices[2] = "3. Check ammo";
    }

    /**
     * Returns the description of the safehouse scenario.
     * 
     * @return description text of the safehouse
     */
    @Override
    public String getDescription() {
        return "A 31-year-old Jason wakes up in a battered safehouse, its walls cracked and windows boarded up.\n"
             + "Supplies are running low, and the faint moans of zombies echo outside.\n"
             + "The air smells of dust and decay. He knows he can’t stay here much longer.";
    }

    /**
     * Prints the available choices to the player.
     */
    @Override
    public void getChoices() {
        for (int index=0; index < choices.length; index++) {
            if (choices[index] != null) {
                System.out.println(choices[index]);
            }
        }
    }

    /**
     * Applies the player's selected choice by index.
     * If the choice is invalid, it prompts the player again.
     * 
     * @param choiceIndex the index of the choice selected
     */
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
                System.out.println("Please input a number from 1 to 3");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                applyChoice(choice);
        }
    }

    /**
     * Handles logic for inspecting and using food.
     */
    public void Choice1() {
        System.out.println("Not much remaining. Half a bottle of water and a can of Heinz beans.");
        System.out.println("Press 1 to Eat.\nPress 2 to pack into backpack");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            Player.heal();
        } else if (choice == 2) {
            Backpack.add("Water");
            Backpack.add("Beans");
        } else {
            System.out.println("Invalid choice. Try again\n \n");
            Choice1();
        }

        choices[0] = null;
        ChooseAgain();
    }

    /**
    * Displays Jason's plan to escape the safehouse and outlines his next objectives.
    */
    public void Choice2() {
        System.out.println("Jason: I can't stay here any longer... it's time to make a move.");
        System.out.println("He spreads out an old, tattered map on the table and studies it under the flickering light.");
        System.out.println("With a broken pencil, he traces a path with shaky hands.");
        System.out.println("Jason: There's an island a few miles east — looks like my best shot.");
        System.out.println("He exhales slowly, his finger stopping at a spot marked 'Docks'.");
        System.out.println("Jason: First, I'll need a car to reach the docks. From there... I pray there's a boat.");
        
        choices[1] = null;
        ChooseAgain();
    }
    
    /**
    * Handles logic for checking Jason's ammunition supply.
    */
    public void Choice3() {
        System.out.println("Jason rummages through the dusty drawers and cracked cabinets, searching for anything useful.");
        System.out.println("He finds a worn-out pistol and a small box of bullets — only 2 rounds inside.");
        System.out.println("Jason packs the pistol and ammo carefully into his backpack.");

        for (int i =0; i<2; i++) {
            Backpack.add("Pistol (one round)");
        }
        
        choices[2] = null;
        ChooseAgain();
    }

    /**
     * Prompts the player to choose again from remaining options.
     */
    public void ChooseAgain() {
        // Check if any choices remain
        boolean hasRemainingChoices = false;
        for (String choice : choices) {
            if (choice != null) {
                hasRemainingChoices = true;
                break;
            }
        }

        if (!hasRemainingChoices) {
            System.out.println("Jason has done everything he can in the safehouse. It's time to move on.");
            GameEngine.moveToNextScenario();
            return;
        }

        // Otherwise, show remaining choices
        System.out.println("\n");
        getChoices();
        int choiceindex;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            choiceindex = scanner.nextInt();
            if (choiceindex >= 1 && choiceindex <= 3 && choices[choiceindex - 1] != null) {
                break; // valid input
            } else {
                System.out.println("Invalid choice. Pick one of the remaining options.");
            }
        }
        applyChoice(choiceindex);
    }
}
