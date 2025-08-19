package zombiewar;

// Abstract class for all zombies
public abstract class Zombie extends Character {
    // Mutation that the zombie has
    protected Mutation zombieMutation;

    // Constructor sets the zombie specific name, health, and base attack values
    public Zombie(String name, int health, int attack, Mutation zombieMutation) {
        super(name, health, attack);
        this.zombieMutation = zombieMutation;
        this.name = zombieMutation.getName() + " " + name; // Puts the mutation type in the zombie's name
        this.attack = attack * zombieMutation.getDamageMultiplier(); // Applies the mutation's damage multiplier

        if (zombieMutation.getHealthMultiplier() > 1) // Only buffs the zombie's health if the multiplier is more than one
            this.health += (int) (health * zombieMutation.getHealthMultiplier()); // Applies the mutation's health multiplier (rounded to int)
    }

    // Zombies attack by biting
    @Override
    public AttackResult attackTarget(Character target, java.util.Random rand) {
        int damage = this.attack;
        target.takeDamage(damage);
        boolean killed = !target.isAlive();
        return new AttackResult(this.name, target.getName(), "Biting", true, damage, killed);
    }

    @Override
    public String toString() {
        return  "- " + this.name + " -> " + zombieMutation.toString();
    }
}
