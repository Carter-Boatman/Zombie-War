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
        pool.add(new Mutation("Feral", 3.5, 0.2)); //reduce damage mult from 6 to 3.5
        pool.add(new Mutation("Spiky", 2, 1)); //reduced damage mult from 4 to 2
        pool.add(new Mutation("Fresh", 2, 0.4)); //reduced damage mult from 3 to 2 and increased health mult from 0.2 to 0.4
        pool.add(new Mutation("Unmutated", 1, 1)); //for creating normal zombies
        
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

    // Picks a mutation from the list or returns null if the list is empty
    public Mutation pickMutation(List<Mutation> list) {
        if (list.isEmpty()) return null;
        return list.remove(0);
    }
}
