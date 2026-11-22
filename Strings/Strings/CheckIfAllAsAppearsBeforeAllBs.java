
# Check if All A's Appears Before All B's

## Approach

1. If the string contains only one character, return `true`.
2. Traverse the string and check each pair of adjacent characters.
3. If the current character is `'b'` and the next character is `'a'`, return `false` because an `'a'` appears after a `'b'`.
4. If no such pair is found, return `true`.

## Java Code

```java
class Solution {
    public boolean checkString(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
                return false;
            }
        }

        return true;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) — We traverse the string once.
- **Space Complexity:** O(1) — No additional data structures are used.

## Key Concepts

- String Traversal
- Character Comparison
- Conditional Checking
