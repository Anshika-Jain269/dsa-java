// Problem: 677. Map Sum Pairs
//
// Approach:
// 1. Use a HashMap to store each key and its value.
// 2. In insert(), add or update the key-value pair.
// 3. In sum(), traverse all keys in the HashMap.
// 4. Check whether each key starts with the given prefix.
// 5. If it matches, add its value to the sum.
//
// Time Complexity:
// insert() -> O(1) average
// sum() -> O(n * L)
//
// Space Complexity: O(n * L)
//
// n = number of keys
// L = length of the key/prefix

import java.util.*;

class MapSum {

    HashMap<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {

        int sum = 0;

        for (String key : map.keySet()) {

            if (key.startsWith(prefix)) {
                sum += map.get(key);
            }
        }

        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 *
 * MapSum obj = new MapSum();
 * obj.insert(key, val);
 * int param_2 = obj.sum(prefix);
 */
