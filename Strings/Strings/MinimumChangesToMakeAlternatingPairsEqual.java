
# Minimum Changes to Make Alternating Pairs Equal

## Approach

1. Initialize a counter `count` to store the number of changes required.
2. Traverse the string using a loop with an increment of 2, since we process the characters in pairs.
3. For each pair, compare the characters at indices `i` and `i + 1`.
4. If both characters are different, increment `count`.
5. Return the total count.

## Java Code

```java
class Solution {
    public int minChanges(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }

        return count;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) — Each pair of characters is checked once.
- **Space Complexity:** O(1) — Only a counter variable is used.

## Key Concepts

- String Traversal
- Character Comparison
- Pairwise Processing

## Commit Message

`Implement minimum changes using pairwise character comparison`
