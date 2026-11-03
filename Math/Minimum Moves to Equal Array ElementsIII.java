
# Minimum Moves to Equal Array Elements

## Approach
1. Find the maximum element and calculate the sum of all elements.
2. To make every element equal to the maximum, each element needs `max - nums[i]` increments.
3. The total number of moves is `n * max - sum`.

## Java Code
```java
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return (nums.length * max) - sum;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), where n is the length of the array, because we traverse the array once.
- **Space Complexity:** O(1), because we use only a constant number of extra variables.
