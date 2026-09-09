class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            if (direction == 1) {
                diff[start]++;
                diff[end + 1]--;
            } else {
                diff[start]--;
                diff[end + 1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int shift = 0;
        for (int i = 0; i < s.length(); i++) {
            shift += diff[i];
            int ch = s.charAt(i) - 'a';
            ch = (ch + shift) % 26;
            if (ch < 0) {
                ch += 26;
            }
            sb.append((char) (ch + 'a'));
        }
        return sb.toString();
    }
}
