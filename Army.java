package zombiewar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Army groups characters and coordinates their attacks against an enemy army
public class Army {
    String armyType;
    ArrayList<Character> armyList;
    private final Random rand = new Random();

    public Army(String armyType, ArrayList<Character> armyList) {
        this.armyType = armyType;
        this.armyList = armyList;
    }

    public void initiateAttack(Army enemyArmy) {
        for (Character attacker : armyList) {
            if (!attacker.isAlive()) continue;
            Character target = firstLiving(enemyArmy.armyList);
            if (target == null) return;
            AttackResult result = attacker.attackTarget(target, rand);
            printAttack(result);
            if (!target.isAlive()) {
                enemyArmy.removeDead();
            }
        }
    }

    private Character firstLiving(ArrayList<Character> list) {
        for (Character c : list) {
            if (c.isAlive()) return c;
        }
        return null;
    }

    public void removeDead() {
        Iterator<Character> it = armyList.iterator();
        while (it.hasNext()) {
            if (!it.next().isAlive()) {
                it.remove();
            }
        }
    }

    private void printAttack(AttackResult r) {
        if (r.hit) {
            System.out.println(r.attackerName + " hit " + r.targetName + " with " + r.weaponName + " for " + r.damage + " damage.");
            if (r.killedTarget) {
                System.out.println(r.attackerName + " killed " + r.targetName + " using " + r.weaponName + ".");
            }
        } else {
            System.out.println(r.attackerName + " missed " + r.targetName + " with " + r.weaponName + ".");
        }
    }

    public boolean hasLiving() {
        for (Character c : armyList) {
            if (c.isAlive()) return true;
        }
        return false;
    }
}
