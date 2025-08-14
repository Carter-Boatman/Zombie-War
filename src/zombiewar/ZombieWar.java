package zombiewar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Main class that runs the Zombie War simulation
public class ZombieWar {

    // ANSI escape codes for colors.
    private static final String RESET = "\u001B[0m";
    private static final String RED   = "\u001B[31m";
   
    // One shared Random for the entire program to avoid repeat seeding.
    private static final Random RNG = new Random();

    // Single shared Scanner for user input (do not close System.in).
    private static final java.util.Scanner IN = new java.util.Scanner(System.in);

    // Method to print text slowly (typewriter effect).
    private static void typewriter(String text, int delayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(delayMs); } catch (InterruptedException ignored) {}
        }
    }

    // Clear screen works in external terminal.
    private static void clearScreen() {
        System.out.print("\u001B[2J\u001B[H");
    }

    // Prints suspense dots with delay for dramatic effect.
    private static void suspenseDots(int count, int delayMs) {
        for (int i = 0; i < count; i++) {
            System.out.print(".");
            try { Thread.sleep(delayMs); } catch (InterruptedException ignored) {}
        }
    }

    // Prompt the user and wait until they press Enter.
    private static void waitForEnter(String prompt) {
        System.out.print(prompt);
        System.out.print(RESET); // Ensure color is reset before input.
        try {
            IN.nextLine(); // Wait for the user to press Enter.
        } catch (Exception ignored) {
            // If input is closed or unavailable, just continue.
        }
        System.out.println(); // Add a blank line after the prompt.
    }

    // Ask the user if they want to play again (Y/N).
    private static boolean playAgainPrompt() {
        System.out.print("Would you like to play again? (Y/N): ");
        String input = IN.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

    // Optional spooky ASCII banner.
    private static void asciiBanner() {
        System.out.println(RED +
            "\r\n"
            + "▒███████▒ ▒█████   ███▄ ▄███▓ ▄▄▄▄    ██▓▓█████        █     █░ ▄▄▄       ██▀███  \r\n"
            + "▒ ▒ ▒ ▄▀░▒██▒  ██▒▓██▒▀█▀ ██▒▓█████▄ ▓██▒▓█   ▀       ▓█░ █ ░█░▒████▄    ▓██ ▒ ██▒\r\n"
            + "░ ▒ ▄▀▒░ ▒██░  ██▒▓██    ▓██░▒██▒ ▄██▒██▒▒███         ▒█░ █ ░█ ▒██  ▀█▄  ▓██ ░▄█ ▒\r\n"
            + "  ▄▀▒   ░▒██   ██░▒██    ▒██ ▒██░█▀  ░██░▒▓█  ▄       ░█░ █ ░█ ░██▄▄▄▄██ ▒██▀▀█▄  \r\n"
            + "▒███████▒░ ████▓▒░▒██▒   ░██▒░▓█  ▀█▓░██░░▒████▒      ░░██▒██▓  ▓█   ▓██▒░██▓ ▒██▒\r\n"
            + "░▒▒ ▓░▒░▒░ ▒░▒░▒░ ░ ▒░   ░  ░░▒▓███▀▒░▓  ░░ ▒░ ░      ░ ▓░▒ ▒   ▒▒   ▓▒█░░ ▒▓ ░▒▓░\r\n"
            + "░░▒ ▒ ░ ▒  ░ ▒ ▒░ ░  ░      ░▒░▒   ░  ▒ ░ ░ ░  ░        ▒ ░ ░    ▒   ▒▒ ░  ░▒ ░ ▒░\r\n"
            + "░ ░ ░ ░ ░░ ░ ░ ▒  ░      ░    ░    ░  ▒ ░   ░           ░   ░    ░   ▒     ░░   ░ \r\n"
            + "  ░ ░        ░ ░         ░    ░       ░     ░  ░          ░          ░  ░   ░     \r\n"
            + "░                                  ░                                              \r\n"
            + RESET);
    }

    // Spooky intro sequence.
    private static void spookyIntro() {
        clearScreen();
        asciiBanner();
        System.out.println(RED);
        typewriter("Can the survivors outlast the zombies and reach safety in the epic war game?\n\n", 30);
        suspenseDots(3, 350); // Prints "..." slowly.
        System.out.println();
        waitForEnter("\nPress ENTER if you dare...");
    }

    public static void main(String[] args) {
        // This boolean variable stores whether the player wants to play again.
        boolean playAgain;
        
        // This loop will run the entire game at least once and then repeat if the player chooses to play again.
        do {
            // This method displays the spooky introduction before the game starts.
            spookyIntro();

            // This generates a random number of survivors between 5 and 20.
            int numSurvivors = RNG.nextInt(16) + 5;

            // This generates a random number of zombies between 3 and 10.
            int numZombies = RNG.nextInt(8) + 3;

            // This creates an ArrayList to hold all survivor characters.
            ArrayList<Character> survivors = new ArrayList<>();

            // This loop creates survivors and randomly assigns them as Soldiers, Civilians, or Scientists.
            for (int i = 0; i < numSurvivors; i++) {
                int pick = RNG.nextInt(3); // Randomly choose a survivor type.
                if (pick == 0) survivors.add(new Soldier("Soldier" + " " + (i + 1))); // Add a Soldier.
                else if (pick == 1) survivors.add(new Civilian("Civilian" + " " + (i + 1))); // Add a Civilian.
                else survivors.add(new Scientist("Scientist" + " " + (i + 1))); // Add a Scientist.
            }

            // This creates an ArrayList to hold all zombie characters.
            ArrayList<Character> zombies = new ArrayList<>();

            // This loop creates zombies and randomly assigns them as CommonInfected or Tanks.
            for (int j = 0; j < numZombies; j++) {
                int pick = RNG.nextInt(2); // Randomly choose a zombie type.
                if (pick == 0) zombies.add(new CommonInfected("Infected" + " " + (j + 1))); // Add a Common Infected.
                else zombies.add(new Tank("Tank" + " " + (j + 1))); // Add a Tank zombie.
            }

            // This creates a WeaponCache object to generate and store weapons for survivors.
            WeaponCache cacheGenerator = new WeaponCache();

            // This generates a random cache of weapons with a size between the number of survivors and that number plus five.
            List<Weapon> cache = cacheGenerator.generateCache(numSurvivors, numSurvivors + 5);

            // This loop assigns a random weapon from the cache to each survivor.
            for (Character c : survivors) {
                if (c instanceof Survivor) {
                    Weapon w = cacheGenerator.drawOne(cache); // Draw one weapon from the cache.
                    ((Survivor) c).setWeapon(w); // Assign the weapon to the survivor.
                }
            }

            // This displays the total number of survivors.
            System.out.println("\nSurvivors: " + survivors.size());

            // This displays the total number of zombies.
            System.out.println("Zombies: " + zombies.size());

            // This displays the list of weapons assigned to each survivor.
            System.out.println("\nWeapons assigned to survivors:\n");
            for (Character c : survivors) {
                if (c instanceof Survivor) {
                    Weapon w = ((Survivor) c).getWeapon(); // Get the survivor's weapon.
                    String wText = (w == null) ? "Unarmed" : w.toString(); // Display "Unarmed" if they have no weapon.
                    System.out.println(" - " + c.getName() + " -> " + wText); // Print survivor and weapon info.
                }
            }
            System.out.println();

            // This creates an Army object for survivors containing all survivor characters.
            Army survivorArmy = new Army("\nSurvivors", survivors);

            // This creates an Army object for zombies containing all zombie characters.
            Army zombieArmy = new Army("\nZombies", zombies);

            // This keeps track of the current round number in the battle.
            int round = 1;

            // This loop continues as long as both armies still have living members.
            while (survivorArmy.hasLiving() && zombieArmy.hasLiving()) {
                System.out.println("\n--- Round " + round + " ---\n"); // Print the round number.

                // This makes the survivors attack the zombies first.
                survivorArmy.initiateAttack(zombieArmy);

                // This checks if all zombies have been defeated and ends the battle if so.
                if (!zombieArmy.hasLiving()) break;

                // This makes the zombies attack the survivors next.
                zombieArmy.initiateAttack(survivorArmy);

                // This removes any dead survivors from the survivor army.
                survivorArmy.removeDead();

                // This removes any dead zombies from the zombie army.
                zombieArmy.removeDead();

                // This increments the round number after each exchange of attacks.
                round++;
            }

            // This message is displayed if there are survivors still alive after the battle.
            if (survivorArmy.hasLiving()) {
                System.out.println("\nIt seems " + survivors.size() + " survivors have made it to safety.\n");
            } 
            // This message is displayed if all survivors have been defeated.
            else {
                System.out.println("\nNone of the survivors made it.");
            }

            // This asks the player if they would like to play the game again.
            playAgain = playAgainPrompt();

        // This continues the loop if the player chooses to play again.
        } while (playAgain);

        // This final message thanks the player for playing once they choose not to play again.
        System.out.println("\nThanks for playing Zombie War!");
    }
}