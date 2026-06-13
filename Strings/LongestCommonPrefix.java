/*
Problem: Longest Common Prefix
LeetCode: 14
Difficulty: Easy

Approach:
- Take the first string as the initial prefix.
- Compare it with every other string.
- Keep shortening the prefix until the current string starts with it.
- Return the remaining prefix.

Time Complexity: O(n logn * m)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public String longestCommonPrefix(String[] strs) {
  if(strs==null || strs.length==0) return "";
      Arrays.sort(strs);
      String first=strs[0];
      String last=strs[strs.length-1];
      int i=0;
      while(i<first.length() && i<last.length()&& first.charAt(i)==last.charAt(i)){
        i++;
      }
      return fisrt.substring(0,i);
    }
}
