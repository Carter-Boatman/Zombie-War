package zombiewar;

import java.util.*; // Importing utilities for list and random

// Main class that runs the Zombie War simulation
public class ZombieWar {

    public static void main(String[] args) {

        // Random number generator
        Random rand = new Random();

        // Generate between 5 and 20 survivors
        int numSurvivors = rand.nextInt(16) + 5;

        // Generate between 3 and 10 zombies
        int numZombies = rand.nextInt(8) + 3;

        // Creates and populates Survivor List
        ArrayList<Character> survivors = new ArrayList<>();
        for (int i = 0; i < numSurvivors; i++) {
            int type = rand.nextInt(3); // 0 = Scientist, 1 = Civilian, 2 = Soldier
            switch (type) {
                case 0:
                    survivors.add(new Scientist("Scientist_" + i));
                    break;
                case 1:
                    survivors.add(new Civilian("Civilian_" + i));
                    break;
                case 2:
                    survivors.add(new Soldier("Soldier_" + i));
                    break;
            }
        }

        // Creates and populates Zombie List
        ArrayList<Character> zombies = new ArrayList<>();
        for (int i = 0; i < numZombies; i++) {
            int type = rand.nextInt(2); // 0 = Common Infected, 1 = Tank
            switch (type) {
                case 0:
                    zombies.add(new CommonInfected("Common_Infected_" + i));
                    break;
                case 1:
                    zombies.add(new Tank("Tank_" + i));
                    break;
            }
        }

        // Army objects created using corresponding lists
        Army survivorArmy = new Army("Survivor", survivors);
        Army zombieArmy = new Army("Zombie", zombies);

        // Counts the number of specific units in survivor army
        int civilianCount = 0;
        int soldierCount = 0;
        int scientistCount = 0;
        for (Character survivor : survivors) {
            if (survivor instanceof Civilian) {
                civilianCount++;
            } else if (survivor instanceof Soldier) {
                soldierCount++;
            } else {
                scientistCount++;
            }
        }

        // Counts the number of specific units in zombie army
        int commonCount = 0;
        int tankCount = 0;
        for (Character zombie : zombies) {
            if (zombie instanceof CommonInfected) {
                commonCount++;
            } else {
                tankCount++;
            }
        }

        // Display starting info including character type amounts
        System.out.println("\nWe have " + numSurvivors + " survivors trying to make it to safety (" + scientistCount + " scientist, " + civilianCount + " civilian, " + soldierCount + " soldier)\n");
        System.out.println("But there are " + numZombies + " zombies waiting for them (" + commonCount + " common infected, " + tankCount + " tank)\n");

        // The battle continues until one side is gone
        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            // Each survivor attacks each zombie
            survivorArmy.initiateAttack(zombieArmy);
            zombies.removeIf(z -> !z.isAlive()); // Remove dead zombies

            // Each zombie attacks each survivor
            zombieArmy.initiateAttack(survivorArmy);
            survivors.removeIf(s -> !s.isAlive()); // Remove dead survivors

            // Remove dead survivors
            survivors.removeIf(s -> !s.isAlive());
        }

        // Display final survivor count
        if (!survivors.isEmpty()) {
            System.out.println("\nIt seems " + survivors.size() + " survivors have made it to safety.");
        } else {
            System.out.println("\nNone of the survivors made it.");
        }
    }
}
