package zombiewar;

// Abstract base class for all characters in the game
public abstract class Character {
    // The name of the character for display in the console
    protected String name;
    // The current health of the character; when this reaches zero the character is dead
    protected int health;
    // The base attack of the character; zombies will use this directly and survivors can augment it with a weapon
    protected int attack;

    // Constructor sets the name, health, and base attack values
    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    // Returns true if the character is still alive, false otherwise
    public boolean isAlive() {
        return health > 0;
    }

    // Decreases the health of the character by a specified damage amount
    public void takeDamage(int damage) {
        if (damage < 0) damage = 0;
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    // Returns the base attack value for the character
    public int getAttack() {
        return attack;
    }

    // Returns the name of the character for printing
    public String getName() {
        return name;
    }

    // Returns the current health of the character for status checks
    public int getHealth() {
        return health;
    }

    // Every character can attack a target; by default this uses the base attack only
    public AttackResult attackTarget(Character target, java.util.Random rand) {
        int damage = this.attack;
        target.takeDamage(damage);
        boolean killed = !target.isAlive();
        return new AttackResult(this.name, target.getName(), "Base Attack", true, damage, killed);
    }
}
