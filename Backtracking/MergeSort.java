class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Recursively divides the array into smaller halves.
    public void mergeSort(int[] nums, int start, int end) {

        // Base case: one or zero elements are already sorted.
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        // Sort the left half.
        mergeSort(nums, start, mid);

        // Sort the right half.
        mergeSort(nums, mid + 1, end);

        // Merge the two sorted halves.
        merge(nums, start, mid, end);
    }

    // Merges two sorted halves into a single sorted section.
    public void merge(int[] nums, int start, int mid, int end) {

        ArrayList<Integer> temp = new ArrayList<>();

        int i = start;
        int j = mid + 1;

        // Compare elements from both halves and store in sorted order.
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        // Add remaining elements from the left half.
        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        // Add remaining elements from the right half.
        while (j <= end) {
            temp.add(nums[j]);
            j++;
        }

        // Copy the sorted elements back into the original array.
        for (int k = 0; k < temp.size(); k++) {
            nums[start + k] = temp.get(k);
        }
    }
}
