package zombiewar;

import java.util.ArrayList;
import java.util.List;

// WeaponFactory creates known weapons with stats.
public class WeaponFactory {
    // Builds the default list of weapons
    public static List<Weapon> defaultWeaponPool() {
        List<Weapon> pool = new ArrayList<>();
        pool.add(new Weapon("Shotgun", 90, 60));
        pool.add(new Weapon("Submachine Gun", 70, 75));
        pool.add(new Weapon("Assault Rifle", 80, 70));
        pool.add(new Weapon("Pistol", 50, 85));
        pool.add(new Weapon("Axe", 65, 80));
        pool.add(new Weapon("Crowbar", 55, 78));
        pool.add(new Weapon("Frying Pan", 40, 90));
        return pool;
    }
}
