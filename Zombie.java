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
        this.health += (int) (health * zombieMutation.getHealthMultiplier()); // Applies the mutation's health multiplier (rounded to int)
        this.attack = attack * zombieMutation.getDamageMultiplier(); // Applies the mutation's damage multiplier
    }

    //public void setZombieMutation(Mutation zombieMutation) { this.zombieMutation = zombieMutation; }
    public Mutation getZombieMutation() { return zombieMutation; }

    // Zombies attack with their entire bodies, but deal damage with bites and do not miss; we will reuse the base attack behavior
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
