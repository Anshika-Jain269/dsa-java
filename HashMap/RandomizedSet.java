import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    /*
     * Approach:
     * We use both an ArrayList and a HashMap.
     *
     * ArrayList:
     * - Stores all the elements.
     * - Allows O(1) access by index.
     *
     * HashMap:
     * - Stores each value and its index in the ArrayList.
     * - Allows O(1) lookup.
     *
     * For O(1) removal:
     * Instead of shifting elements after removing an element,
     * we replace the element to be removed with the last element.
     *
     * Example:
     * ArrayList = [10, 20, 30, 40]
     * Remove 20
     *
     * Replace 20 with the last element 40:
     * [10, 40, 30, 40]
     *
     * Then remove the last element:
     * [10, 40, 30]
     *
     * We also update the index of 40 in the HashMap.
     *
     * getRandom() uses the ArrayList index, so a random element
     * can be returned in O(1) time.
     *
     * Time Complexity:
     * insert()   -> O(1) average
     * remove()   -> O(1) average
     * getRandom()-> O(1)
     *
     * Space Complexity: O(n)
     */

    ArrayList<Integer> set = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {

        // If value already exists, insertion is not possible
        if (map.containsKey(val)) {
            return false;
        }

        // Add value to the ArrayList
        set.add(val);

        // Store the value and its index
        map.put(val, set.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        // If value does not exist, removal is not possible
        if (!map.containsKey(val)) {
            return false;
        }

        // Index of the element to be removed
        int first = map.get(val);

        // Get the last element of the ArrayList
        int last = set.get(set.size() - 1);

        // Replace the element to remove with the last element
        set.set(first, last);

        // Update the index of the last element
        map.put(last, first);

        // Remove the duplicate last element
        set.remove(set.size() - 1);

        // Remove the value from the HashMap
        map.remove(val);

        return true;
    }

    public int getRandom() {

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(set.size());

        // Return the element at that index
        return set.get(randomIndex);
    }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 *
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
