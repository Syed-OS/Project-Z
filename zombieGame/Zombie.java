package zombieGame;

import java.util.Random;

/**
 * The Zombie class represents a zombie in the game.
 * A Zombie can make random sounds and has a dead/alive condition.
 * 
 * @author Syed Mahir Ahamed
 */

public class Zombie {
    private boolean dead;

    /**
     * Constructs a Zombie with default alive status (not dead).
     */
    public Zombie() {
        dead = false;
    }

    /**
     * Gets the zombie's condition (dead or alive).
     * 
     * @return true if the zombie is dead; false otherwise
     */
    public boolean getCondition() {
        return dead;
    }

    /**
     * Marks the zombie as dead.
     */
    public void die() {
       dead = true;
    }
    
    /**
     * Generates and returns a random zombie sound.
     * 
     * @return a random zombie sound as a String
     */
    public String makeSound(){
        String[] zombieSounds = {
            "Uuuuughhhh...",
            "Raaaagghhhh...",
            "Grrrrrrrr...",
            "Graaaaahhhh!",
            "Hssssssss...",
            "Mmmmmmnnnn...",
            "Aaaarghhh!",
            "Rrrraaaarrr!",
            "Bluhhhhhh...",
            "Nnnnnnnngghh!"
        };

        Random rand = new Random();
        int index = rand.nextInt(zombieSounds.length);
        return zombieSounds[index];
    }

    public static void main(String[] args) {
        
    }
}
