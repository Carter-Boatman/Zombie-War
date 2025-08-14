package zombiewar;

// Weapon stores the name, damage, and accuracy percentage
public class Weapon {
    // Display name of the weapon
    private final String name;
    // Damage dealt on a successful hit
    private final int damage;
    // Chance to hit out of 100
    private final int accuracyPercent;

    // Constructor sets the basic stats for this weapon
    public Weapon(String name, int damage, int accuracyPercent) {
        this.name = name;
        this.damage = damage;
        this.accuracyPercent = accuracyPercent;
    }

    // Returns the weapon name
    public String getName() {
        return name;
    }

    // Returns the weapon damage per hit
    public int getDamage() {
        return damage;
    }

    // Returns the accuracy % between 0 and 100
    public int getAccuracyPercent() {
        return accuracyPercent;
    }

    // Returns a summary of the damage and accuracy. 
    @Override
    public String toString() {
        return name + " (Damage " + damage + ", Accuracy " + accuracyPercent + "%)";
    }
}
