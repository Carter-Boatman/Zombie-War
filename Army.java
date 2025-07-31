package zombiewar;

import java.util.ArrayList;

public class Army {
    String armyType; // Human or Zombie
    ArrayList<Character> armyList; // Holds all character objects in the army
    int armySize;


    // Constructor
    public Army(String armyType, ArrayList<Character> armyList) {
        this.armyType = armyType;
        this.armyList = armyList;
        this.armySize = armyList.size();
    }

    // Each member of the Army attack the corresponding members of the enemyArmy
    public void initiateAttack(Army enemyArmy) {
        for (Character member : armyList) {
            for (Character enemy : enemyArmy.armyList) {
                if (enemy.isAlive()) {
                    enemy.takeDamage(member.getAttack());
                    if (!enemy.isAlive())
                        System.out.println(member.name + " killed " + enemy.name);
                }
            }
        }
    }
}
