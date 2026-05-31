
   // LeetCode 169 - Majority Element
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {

        // Assume first element is majority candidate
        int candidate = nums[0];
        int count = 1;

        // Boyer-Moore Voting Algorithm
        for (int i = 1; i < nums.length; i++) {

            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }

            // Increase count if same element
            else if (nums[i] == candidate) {
                count++;
            }

            // Decrease count if different element
            else {
                count--;
            }
        }

        return candidate;
    }
}
