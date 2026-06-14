/*
Problem: Permutation in String
LeetCode: 567
Difficulty: Medium

Approach:
- Store frequency of characters from s1.
- Use a sliding window on s2.
- Decrease frequency when a character enters the window.
- Increase frequency when a character leaves the window.
- Maintain a count of remaining characters to match.
- If count becomes 0, a permutation exists.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public boolean checkInclusion(String s1, String s2) {
      

        if (s1.length() > s2.length()) {
            return false;
        }
      int[] s1count=new int[26];
      int[] s2count=new int[26];
      for(int i=0;i<s1.length();i++){
        s1count[s1.charAt(i)-'a]++;
        s2count[s2.charAt(i)-'a]++;
      }
      if(Arrays.equals(s1count,s2count) ) return true;
      for(int i=s1.length();i<s2.length();i++){
        s2count[s2.charAt(i)-'a]++;
        s2count[s2.charAt(i-s1.length())-'a']--;
        if(Arrays.equals(s1count,s2count)) return true;
      } 
      return false;
    }
}

       
