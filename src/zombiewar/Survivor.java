package zombiewar;

// Abstract class for survivors that may carry a weapon
public abstract class Survivor extends Character {
    // The weapon that this survivor is currently holding; it can be null if no weapon is assigned
    protected Weapon weapon;

    // Constructor sets the name, health, and base attack values for the survivor
    public Survivor(String name, int health, int attack) {
        super(name, health, attack);
    }

    // Assigns a weapon to this survivor for use during attacks
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Returns the weapon reference for reporting purposes
    public Weapon getWeapon() {
        return this.weapon;
    }

    // Survivors attack using their weapon accuracy and weapon damage if a weapon is available
    @Override
    public AttackResult attackTarget(Character target, java.util.Random rand) {
        if (weapon == null) {
            int damage = this.attack;
            target.takeDamage(damage);
            boolean killed = !target.isAlive();
            return new AttackResult(this.name, target.getName(), "Unarmed", true, damage, killed);
        }
        int roll = rand.nextInt(100);
        boolean hit = roll < weapon.getAccuracyPercent();
        int damageDealt = 0;
        boolean killed = false;
        if (hit) {
            damageDealt = weapon.getDamage();
            target.takeDamage(damageDealt);
            killed = !target.isAlive();
        }
        return new AttackResult(this.name, target.getName(), weapon.getName(), hit, damageDealt, killed);
    }
}
