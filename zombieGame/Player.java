package zombieGame;

/**
 * The Player class represents a game player with health and condition.
 * A Player can take damage, heal, and has a name and alive/dead status.
 * 
 * @author Syed Mahir Ahamed
 */

public class Player {
    private static int health;
    private static final String name = "Jason";
    private static boolean dead;

    /**
     * Constructs a Player with default health (100) and alive status (false).
     */
    public Player() {
        health = 100;
        dead = false;
    }

    /**
     * Gets the player's name.
     * 
     * @return the name of the player ("Jason")
     */
    public static String getName() {
        return name;
    }

    /**
     * Gets the player's current health.
     * 
     * @return the current health value
     */
    public static int getHealth() {
        return health;
    }

    /**
     * Gets the player's condition (dead or alive).
     * 
     * @return true if the player is dead; false otherwise
     */
    public static boolean getCondition() {
        return dead;
    }

    /**
     * Heals the player. If health is 75 or below, increase by 25.
     * Otherwise, set health to 100 (max health).
     */
    public static void heal() {
        if (health<=75) {
            health += 25;
        } else {
            health = 100;
        }
    }

    public static void attack(int strength) {
        
   // Fill this class later on with smth like currentzombie.takedamage()
   // Fix scanner issue
   //Write game.nextscenario change
    }

    /**
     * Applies small damage (10 points) to the player.
     * If health drops to 0 or below, the player dies.
     */
    public static void takeSmallDamage() {
        health -= 10;
        if (health<=0) {
            die();
        }
    }

    /**
     * Applies large damage (25 points) to the player.
     * If health drops to 0 or below, the player dies.
     */
    public static void takeLargeDamage() {
        health -= 25;
        if (health<=0) {
            die();
        }
    }

    /**
     * Marks the player as dead.
     */
    private static void die() {
       dead = true;
    }

    public static void main(String[] args) {
        new Player();  // This sets health = 100, dead = false
        System.out.println("Player created: " + Player.getName());
        System.out.println("Health: " + Player.getHealth());
        System.out.println("Dead: " + Player.getCondition());
    }
}