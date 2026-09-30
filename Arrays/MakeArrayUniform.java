class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean allEven = true;
        boolean allOdd = true;

        for (int i = 0; i < nums1.length; i++) {

            boolean canEven = false;
            boolean canOdd = false;

            // Keep the original number
            if (nums1[i] % 2 == 0) {
                canEven = true;
            } else {
                canOdd = true;
            }

            // Try subtracting another number
            for (int j = 0; j < nums1.length; j++) {

                if (i != j && nums1[i] - nums1[j] >= 1) {

                    int value = nums1[i] - nums1[j];

                    if (value % 2 == 0) {
                        canEven = true;
                    } else {
                        canOdd = true;
                    }
                }
            }

            if (!canEven) {
                allEven = false;
            }

            if (!canOdd) {
                allOdd = false;
            }
        }

        return allEven || allOdd;
    }
}
