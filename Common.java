package zombiewar;

// Common zombie has low stats
public class Common extends Zombie {
    public Common(String name) {
        super(name, 30, 5); // Weak health and attack
    }
}
