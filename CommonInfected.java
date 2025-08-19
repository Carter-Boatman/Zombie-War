package zombiewar;

// Common infected zombie with weak stats
public class CommonInfected extends Zombie {
    public CommonInfected(String name, Mutation mutation) { super(name, 30, 6, mutation); } // Weak health and attack
    //lowered attack to 6 in line with suggestions
}

