import java.util.*;

class Solution {

    // Counts the number of inversions in the array.
    public static long inversionCount(long[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Divides the array and counts inversions in both halves
    // along with inversions formed during merging.
    private static long mergeSort(long[] arr, int start, int end) {

        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        long count = 0;

        // Count inversions in the left half.
        count += mergeSort(arr, start, mid);

        // Count inversions in the right half.
        count += mergeSort(arr, mid + 1, end);

        // Count inversions while merging both halves.
        count += merge(arr, start, mid, end);

        return count;
    }

    // Merges two sorted halves and counts cross inversions.
    private static long merge(long[] arr, int start, int mid, int end) {

        ArrayList<Long> temp = new ArrayList<>();

        int i = start;
        int j = mid + 1;
        long count = 0;

        while (i <= mid && j <= end) {

            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                // All remaining elements in the left half
                // form an inversion with arr[j].
                count += (mid - i + 1);
                temp.add(arr[j]);
                j++;
            }
        }

        // Add remaining elements from the left half.
        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        // Add remaining elements from the right half.
        while (j <= end) {
            temp.add(arr[j]);
            j++;
        }

        // Copy sorted elements back into the original array.
        for (int k = 0; k < temp.size(); k++) {
            arr[start + k] = temp.get(k);
        }

        return count;
    }
}
