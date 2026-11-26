
# Stone Removal Game

## Approach

1. Initialize `take = 10` because Alice removes exactly 10 stones on the first turn.
2. Initialize `steps = 0` to count the total number of successful moves.
3. Use a `while` loop that continues as long as the remaining stones are greater than or equal to the required number of stones.
4. In each iteration:
   - Subtract `take` from `n`.
   - Decrease `take` by 1 for the next turn.
   - Increment `steps`.
5. After the game ends, check the parity of `steps`:
   - If `steps` is odd, Alice wins.
   - If `steps` is even, Bob wins.
6. Return the result.

## Java Code

```java id="q8m2vn"
class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        int steps = 0;

        while (n >= take) {
            n -= take;
            take--;
            steps++;
        }

        return steps % 2 == 1;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(1) — At most 10 successful moves are possible.
- **Space Complexity:** O(1) — Only two variables are used.

## Key Concepts

- Simulation
- Game Theory
- Loop
- Parity Checking
