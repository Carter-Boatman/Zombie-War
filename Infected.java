package zombiewar;

// Infected zombie has same stats as common
public class Infected extends Zombie {
    public Infected(String name) {
        super(name, 30, 5); // Can be used as variation of Common
    }
}
