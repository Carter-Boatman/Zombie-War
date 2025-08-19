package zombiewar;

public class Mutation {
    private final String name;
    private final int damageMultiplier;
    private final double healthMultiplier;

    // Constructor sets the basic stats for this weapon
    public Mutation(String name, int damageMultiplier, double healthMultiplier) {
        this.name = name;
        this.damageMultiplier = damageMultiplier;
        this.healthMultiplier = healthMultiplier;
    }

    // Returns the mutation name
    public String getName() {
        return name;
    }

    // Returns the mutation damage multiplier
    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    // Returns the mutation healthMultiplier
    public double getHealthMultiplier() { return healthMultiplier; }

    // Returns a summary of the damage and accuracy.
    @Override
    public String toString() {
        String mutationString = name + " (Damage Buff: X" + damageMultiplier + ", Health Buff: +" + (int)(100 * healthMultiplier) +"%)";;
        if (healthMultiplier == 1) { mutationString = name + " (Damage Buff: X" + damageMultiplier + ", Health Buff: None)"; } // Output for if there is no health change
        return mutationString;
    }
}
