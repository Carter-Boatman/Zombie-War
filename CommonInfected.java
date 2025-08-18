package zombiewar;

// Common infected zombie with weak stats
public class CommonInfected extends Zombie {
    public CommonInfected(String name, Mutation mutation) { super(name, 30, 20, mutation); } // Weak health and attack
}
