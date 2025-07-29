package zombieGame;

import java.util.Scanner;

public class Street implements Scenario {

    String[] choiceSet1;
    String[] choiceSet2;

    public Street() {
        choiceSet1 = new String[2];
        choiceSet1[0] = "1. Choose stealth";
        choiceSet1[1] = "2. Run";
    }

    @Override
    public String getDescription() {
         return "Jason steps out onto a crumbling street littered with abandoned cars and debris. "
         + "The stench of rot is overwhelming, and the groans of the undead echo between buildings. "
         + "Flickering fires cast eerie shadows, and shapes shuffle in the distance. "
         + "Every step could mean salvation... or death.";
    }

    @Override
    public void getChoices() {
        for (int index=0; index < choiceSet1.length; index++) {
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
            default:
                System.out.println("Please input either 1 or 2");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                applyChoice(choice);
        }
    }

    public void Choice1() {
        System.out.println("Jason tiptoes across the street, crouching to make his frame as unnoticeable as possible.");
        System.out.println("He stays low, weaving between abandoned cars and rubble.");
        System.out.println("A zombie lurches nearby, sniffing the air, but Jason holds his breath and waits...");
        System.out.println("...It stumbles away. He made it halfway across safely.");

        System.out.println("\nSuddenly, a metallic clang echoes as Jason accidentally kicks a tin can.");
        System.out.println("The groans get louder. One zombie turns, then another.");
        System.out.println("Jason: \"Damn it... Move!\"");

        Player.takeSmallDamage(); // He gets grazed during the escape
        System.out.println("Jason gets scratched but manages to duck into an alley.");
    
        System.out.println("\nHe survived, but barely. Time to keep going...");
        GameEngine.moveToNextScenario(3); 
    }

    public void Choice2() {
        System.out.println("Jason breaks into a sprint, boots slamming against broken concrete.");
        System.out.println("The noise is deafening—metal rattles, glass crunches, and every undead ear turns toward him.");
        System.out.println("Groans rise in chorus as a pack of zombies gives chase.");

        System.out.println("He leaps over a wrecked bike, darts between two cars—");
        System.out.println("—and suddenly, one grabs his arm!");

        System.out.println("He fights, kicks, claws—but it's too late.");
        System.out.println("Dozens of hands drag him down. Teeth sink into flesh.");
        System.out.println("Jason lets out one last scream before everything goes black.");

        Player.takeLargeDamage(); // This will trigger game over and restart if health <= 0
        Player.takeLargeDamage(); // Ensure death (double hit) 
    }
}
