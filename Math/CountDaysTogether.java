/*
 * Problem: LeetCode 2409 - Count Days Spent Together
 *
 * Approach:
 * 1. Convert each MM-DD date into its day number in the year.
 * 2. Find the later arrival date using Math.max().
 * 3. Find the earlier departure date using Math.min().
 * 4. Calculate the overlapping days using end - start + 1.
 * 5. If there is no overlap, return 0.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        // Find the later arrival date
        int start = Math.max(day(arriveAlice), day(arriveBob));

        // Find the earlier departure date
        int end = Math.min(day(leaveAlice), day(leaveBob));

        // Count overlapping days, including both endpoints
        return Math.max(0, end - start + 1);
    }

    // Convert an MM-DD date into its day number in the year
    int day(String s) {
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        String[] parts = s.split("-");
        int month = Integer.parseInt(parts[0]);
        int date = Integer.parseInt(parts[1]);

        // Add the days in all previous months
        for (int i = 0; i < month - 1; i++) {
            date += days[i];
        }

        return date;
    }
}
