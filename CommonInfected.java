package zombiewar;

// Common zombie has low stats
public class CommonInfected extends Zombie {
    public CommonInfected(String name) {
        super(name, 30, 5); // Weak health and attack
    }
}