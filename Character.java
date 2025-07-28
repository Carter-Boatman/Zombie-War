package zombiewar;

// Abstract class that defines common features for all characters
public abstract class Character {
    protected String name;   // Character's name
    protected int health;    // Character's health
    protected int attack;    // Character's attack power

    // Constructor to set the name, health, and attack
    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    // Checks if the character is still alive
    public boolean isAlive() {
        return health > 0;
    }

    // Reduces health when damage is taken
    public void takeDamage(int damage) {
        if (isAlive()) {
            health -= damage;
        }
    }

    // Gets the attack value
    public int getAttack() {
        return attack;
    }
}