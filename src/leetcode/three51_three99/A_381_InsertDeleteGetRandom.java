package leetcode.three51_three99;

import java.util.*;

public class A_381_InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedCollection randomizedSet = new RandomizedCollection();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));

        System.out.println(randomizedSet.list);

    }
}

class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;


    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);

        if (!contain) {
            return false;
        }
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(loc, lastOne);
            map.get(lastOne).remove(list.size() - 1);
            map.get(lastOne).add(loc);
        }
        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }


    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/*
solution dau tien la dung list: nhung nhu vay, insert va delete take o(n) time
nen dung them map
khi dung map, van phai dung list, vi dung list moi get random duoc

con cho remove last one:

tui nay cho duplicate,
nen dung map<integer, set<integer>>

 */

/*
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
