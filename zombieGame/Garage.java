package zombieGame;

import java.util.Scanner;

public class Garage implements Scenario {

    String[] choiceSet1;
    boolean hasKey = false;
    boolean hasBattery = false;
    boolean lockerOpened = false;
    boolean drawerOpened = false;

    public Garage() {
        choiceSet1 = new String[3];
        choiceSet1[0] = "1. Check the locker on the left wall";
        choiceSet1[1] = "2. Inspect the workbench";
        choiceSet1[2] = "3. Examine the large drawer at the back";
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
        Scanner scan = new Scanner(System.in);
        while (true) {
            for (int index = 0; index < choiceSet1.length; index++) {
                if (choiceSet1[index] != null) {
                    System.out.println(choiceSet1[index]);
                }
            }
            System.out.print("Enter a number from 1 to 3: ");
            int choiceIndex = scan.nextInt();
            applyChoice(choiceIndex);
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
        }
    }

    public void Choice1() {
        System.out.println("Jason walks cautiously along the left wall of the garage.");
        System.out.println("Among piles of rusted tools and dented oil cans, he finds a tall, metal locker.");

        if (lockerOpened) {
            System.out.println("The locker hangs open. It’s empty now.");
            return;
        }

        System.out.println("The door rattles but doesn’t open — it's locked with a keypad.");
        System.out.println("Scratched into the paint: \"Power rests in two digits.\"");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter code (-1 to stop trying): ");
            int input = scanner.nextInt();

            if (input == -1) {
                System.out.println("Jason steps back from the locker for now.");
                break;
            } else if (input == 83) {
                System.out.println("The lock clicks. The door swings open with a groan.");
                System.out.println("Inside, on a dusty shelf, sits a single car key.");
                System.out.println("Jason takes the key.");
                hasKey = true;
                lockerOpened = true;
                break;
            } else {
                System.out.println("The keypad flashes red. Wrong code.");
            }
        }
    }

    public void Choice2() {
        System.out.println("A scrap of paper lies on the bench, barely held down by a rusted wrench.\n");
        System.out.println("\"Eight they were, with eyes like coal,");
        System.out.println("Clinging to corners, silent and whole.");
        System.out.println("Three more followed, drawn by breath,");
        System.out.println("Together they danced a song of death.\"");
        System.out.println("\nThere’s nothing else on the bench.");
    }

    public void Choice3() {
        System.out.println("Jason approaches a massive red tool drawer pushed against the back wall.");
        System.out.println("Thick dust coats the handles. One drawer in the center has a keyhole.");

        if (drawerOpened) {
            System.out.println("The drawer hangs open. Nothing left inside.");
            return;
        }

        if (!hasKey) {
            System.out.println("He tugs at the handle — locked tight.");
            System.out.println("Looks like it needs a key.");
        } else if (!hasBattery) {
            System.out.println("He slides the key into the drawer and twists.");
            System.out.println("The lock clicks. The drawer creaks open slowly...");
            System.out.println("Inside, resting in a nest of wires and tools, is a heavy car battery.");
            System.out.println("Jason takes it carefully and slings it into his backpack.");
            hasBattery = true;
            drawerOpened = true;

            GameEngine.moveToNextScenario(4);
        }
    }
}
