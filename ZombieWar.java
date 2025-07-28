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

        // List of survivors
        ArrayList<Survivor> survivors = new ArrayList<>();

        // Randomly create survivor types
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

        // List of zombies
        ArrayList<Zombie> zombies = new ArrayList<>();

        // Randomly create zombie types
        for (int i = 0; i < numZombies; i++) {
            int type = rand.nextInt(3); // 0 = Common, 1 = Infected, 2 = Tank
            switch (type) {
                case 0:
                    zombies.add(new Common("Common_" + i));
                    break;
                case 1:
                    zombies.add(new Infected("Infected_" + i));
                    break;
                case 2:
                    zombies.add(new Tank("Tank_" + i));
                    break;
            }
        }

        // Display starting info
        System.out.println("\nWe have " + numSurvivors + " survivors trying to make it to safety.");
        System.out.println("But there are " + numZombies + " zombies waiting for them.");

        // The battle continues until one side is gone
        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            // Each survivor attacks each zombie
            for (Survivor s : survivors) {
                for (Zombie z : zombies) {
                    if (z.isAlive()) {
                        z.takeDamage(s.getAttack());
                    }
                }
            }

            // Remove dead zombies
            zombies.removeIf(z -> !z.isAlive());

            // Each zombie attacks each survivor
            for (Zombie z : zombies) {
                for (Survivor s : survivors) {
                    if (s.isAlive()) {
                        s.takeDamage(z.getAttack());
                    }
                }
            }

            // Remove dead survivors
            survivors.removeIf(s -> !s.isAlive());
        }

        // Display final survivor count
        System.out.println("\nIt seems " + survivors.size() + " survivors have made it to safety.");
    }
}
