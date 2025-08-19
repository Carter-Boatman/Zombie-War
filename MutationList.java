package zombiewar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MutationList {
    // Random instance used for shuffling and drawing mutations
    private final Random rand = new Random();

    // All available mutations
    public static List<Mutation> mutationPool() {
        List<Mutation> pool = new ArrayList<>();
        pool.add(new Mutation("Feral", 4, 0.2)); // x 4 damage, +20% health
        pool.add(new Mutation("Spiky", 2, 1)); // x 2 damage, no health change
        pool.add(new Mutation("Fresh", 2, 0.4)); // x 2 damage, +40% health
        pool.add(new Mutation("Unmutated", 1, 1)); // for creating normal zombies
        return pool;
    }

    // Generates a random mutation list
    public List<Mutation> generateMutations(int min, int max) {
        int size = min + rand.nextInt((max - min) + 1);
        List<Mutation> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Mutation type = mutationPool().get(rand.nextInt(mutationPool().size()));
            list.add(new Mutation(type.getName(), type.getDamageMultiplier(), type.getHealthMultiplier()));
        }
        Collections.shuffle(list, rand);
        return list;
    }
}
