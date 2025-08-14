package zombiewar;

// This class is a simple data holder for the results of a single attack.
public class AttackResult {
    // The name of the attacker for display
    public final String attackerName;
    // The name of the target for display
    public final String targetName;
    // The name of the weapon that was used; for zombies this will be "Bites"
    public final String weaponName;
    // True when the attack hit and false when it missed
    public final boolean hit;
    // The damage that was actually dealt during the attack
    public final int damage;
    // True when the target died because of this attack
    public final boolean killedTarget;

    // Constructor sets all fields so they can be printed by the battle loop
    public AttackResult(String attackerName, String targetName, String weaponName, boolean hit, int damage, boolean killedTarget) {
        this.attackerName = attackerName;
        this.targetName = targetName;
        this.weaponName = weaponName;
        this.hit = hit;
        this.damage = damage;
        this.killedTarget = killedTarget;
    }
}
