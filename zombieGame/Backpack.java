package zombieGame;
import java.util.Scanner;

/**
 * The Backpack class represents the player's backpack in the game.
 * It stores items up to a fixed capacity and allows interaction
 * with those items (e.g., using food to heal).
 * 
 * @author Syed Mahir Ahamed
 */

public class Backpack {
    private static String[] inventory;
    private static int size;
    private static final int capacity = 10;
    private String[] foodtypes;
    private int pistolStrength = 10;
    private int macheteStrength = 5;

    /**
     * Constructs the Backpack with empty slots
     * and initializes known food types.
     */
    public Backpack() {
       inventory = new String[capacity];
       size = 0;
       foodtypes = new String[] {"Water", "Beans"};
    }

    /**
     * Returns the number of free slots left in the backpack.
     * 
     * @return the number of empty slots
     */
    public static int spaceLeft() {
        return inventory.length-size;
    }

    /**
     * Adds an item to the first available slot in the backpack.
     * If the backpack is full, displays a message.
     * 
     * @param stuff the item to add
     */
    public static void add(String stuff) {
        boolean added = false;
        for (int i = 0; i < capacity; i++) {
            if (inventory[i] == null) {
                inventory[i] = stuff;
                size++;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Backpack is full! Cannot add " + stuff);
        }
    }

    /**
     * Displays the current items in the backpack,
     * and allows the player to choose one to use.
     */
    public void openBackpack() {
        for (int index=0; index < inventory.length; index++) {
            if (inventory[index] != null) {
                System.out.println((index + 1) + ". " + inventory[index]);
            }
        } 
        System.out.println("Press the corresponding number to use item, and -1 to pass.");
        Scanner scanner = new Scanner(System.in);
        int choiceindex = scanner.nextInt();
        useItem(choiceindex);
    }

    /**
     * Uses the selected item, applying effects if it's food.
     * Removes the item from the backpack after use.
     * 
     * @param choiceindex the number corresponding to the item
     */
    public void useItem(int choiceindex) {
        if (choiceindex >= 1 && choiceindex <= capacity && inventory[choiceindex - 1] != null) {
            String item = inventory[choiceindex - 1];
            if (isFood(item)) {
               Player.heal();
               inventory[choiceindex - 1] = null;
               size--;
            } else if (item.equals("Pistol (one round)")) {
                Player.attack(pistolStrength);
                inventory[choiceindex - 1] = null;
                size--;
           } else if (item.equals("Machete")) {
                Player.attack(macheteStrength);
           }
        }
    }

    /**
     * Checks if the selected item is a food item.
     * 
     * @param choiceindex the number corresponding to the item
     * @return true if the item is food; false otherwise
     */
    public boolean isFood(String item) {
        for (String food : foodtypes) {
            if (food.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
