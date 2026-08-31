class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort balloons by their ending coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        // Position of the first arrow
        int arrow = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // If the current balloon starts after
            // the arrow position, it cannot be burst
            // by the current arrow.
            if (points[i][0] > arrow) {

                arrows++;

                // Shoot a new arrow at this balloon's end
                arrow = points[i][1];
            }
        }

        return arrows;
    }
}
