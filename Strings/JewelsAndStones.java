//LeetCode: 771 – Jewels and Stones
//Technique: String / Brute Force
//Folder: String/
//File: JewelsAndStones.java
//Complexity
//Time: O(J × S)
//Space: O(1)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<jewels.length();i++){
            for(int j=0;j<stones.length();j++){
                  if(jewels.charAt(i)==stones.charAt(j)){
                    count++;
                  }
            }
        }
        return count;
    }
}
