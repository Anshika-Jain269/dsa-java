
# Find the Distance Value Between Two Arrays

## Approach
1. Initialize a counter to store the distance value.
2. Traverse each element of `arr1`.
3. For every element, compare it with all elements of `arr2`.
4. If the absolute difference between any pair is less than or equal to `d`, stop checking that element.
5. If no such element is found in `arr2`, increment the counter.
6. Return the final count.

## Java Code
```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            int j;

            for (j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    break;
                }
            }

            if (j == arr2.length) {
                count++;
            }
        }

        return count;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n × m), where `n` is the length of `arr1` and `m` is the length of `arr2`. Each element of `arr1` may be compared with every element of `arr2`.
- **Space Complexity:** O(1), because only a constant amount of extra space is used.
