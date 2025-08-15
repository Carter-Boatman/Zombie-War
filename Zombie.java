package zombiewar;

// Abstract class for all zombies
public abstract class Zombie extends Character {
    // Constructor sets the zombie specific name, health, and base attack values
    public Zombie(String name, int health, int attack) {
        super(name, health, attack);
    }

    // Zombies attack with their entire bodies, but deal damage with bites and do not miss; we will reuse the base attack behavior
    @Override
    public AttackResult attackTarget(Character target, java.util.Random rand) {
        int damage = this.attack;
        target.takeDamage(damage);
        boolean killed = !target.isAlive();
        return new AttackResult(this.name, target.getName(), "Biting", true, damage, killed);
    }
}
