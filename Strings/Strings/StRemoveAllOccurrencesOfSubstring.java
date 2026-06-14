/*
Problem: Remove All Occurrences of a Substring
LeetCode: 1910
Difficulty: Medium

Approach:
- Keep removing the first occurrence of the substring.
- Use indexOf() to find the substring.
- Continue until the substring no longer exists.

Time Complexity: O(n * m)
Space Complexity: O(n)

Author: Anshika Jain
*/

class Solution {

    public String removeOccurrences(String s, String part) {
  StringBuilder sb=new StringBuilder();
      for(int i=0;i<s.length();i++){
        sb.append(s.charAt(i));
      if(s.length()>=part.length()){
        int start=sb.length()-part.length();
        if(sb.substring(start).equals(part)){
          sb.delete(start,sb.length());
        }
      }
      }
        return sb.toString();
    }
}
