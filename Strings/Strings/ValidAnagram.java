/*
Problem: Valid Anagram
LeetCode: 242
Difficulty: Easy

Approach:
- Use a frequency array of size 26.
- Increment count for characters in first string.
- Decrement count for characters in second string.
- If all counts become zero, both strings are anagrams.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/ 
class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length()){
        return false;
      }
      int[] count=new int[26];
      for(int i=0;i<s.length();i++){
        count[s.charAt(i)-'a']++;
      }
      for(int i=0;i<t.length();i++){
        count[s.charAt(i)-'a']--;
      }
      for(int i=0;i<26;i++){
        if(count[i]!=0){
          return false;
        }
      } 
  return true;
    }
}
