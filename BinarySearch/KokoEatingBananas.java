class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {
            int hours = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }

            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
