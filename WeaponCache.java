package zombiewar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// WeaponCache randomly generates a cache of weapons that survivors can pick from
public class WeaponCache {
    // Random instance used for shuffling and drawing weapons
    private final Random rand = new Random();
    // All available weapon types that can appear in caches
    public static List<Weapon> weaponPool() {
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

    // Generates a random cache list with a size between min and max inclusive
    public List<Weapon> generateCache(int min, int max) {
        int size = min + rand.nextInt((max - min) + 1);
        List<Weapon> cache = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Weapon type = weaponPool().get(rand.nextInt(weaponPool().size()));
            cache.add(new Weapon(type.getName(), type.getDamage(), type.getAccuracyPercent()));
        }
        Collections.shuffle(cache, rand);
        return cache;
    }

    // Draws one weapon from the cache or returns null if the cache is empty
    public Weapon drawOne(List<Weapon> cache) {
        if (cache.isEmpty()) return null;
        return cache.remove(0);
    }
}
