class Solution {
    public void sortInWave(int arr[]) {
        for (int i = 0; i + 1 < arr.length; i++) {
            if (i % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}
