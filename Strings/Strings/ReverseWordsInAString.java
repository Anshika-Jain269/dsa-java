/*
Problem: Reverse Words in a String
LeetCode: 151
Difficulty: Medium

Approach:
- Split the string using one or more spaces.
- Traverse the array from the end.
- Append words in reverse order.
- Remove trailing space using trim().

Time Complexity: O(n)
Space Complexity: O(n)

Author: Anshika Jain
*/

class Solution {

    public String reverseWords(String s) {
  String[] words=s.split("\\s+");
   StringBuilder sb=new StringBuilder();
      for(int i=words.length-1;i>=0;i--){
        sb.append(words[i]);
        sb.append(" ");
}
      return sb.toString().trim();
    }
}
