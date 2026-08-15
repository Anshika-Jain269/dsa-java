import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort the array so duplicate elements are adjacent.
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    // Generates all unique subsets using backtracking.
    public void backtrack(int index, int[] nums,
                          List<Integer> current,
                          List<List<Integer>> result) {

        // Add the current subset to the result.
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Skip duplicate elements at the same recursion level.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current element.
            current.add(nums[i]);

            // Explore subsets starting from the next index.
            backtrack(i + 1, nums, current, result);

            // Backtrack by removing the chosen element.
            current.remove(current.size() - 1);
        }
    }
}
