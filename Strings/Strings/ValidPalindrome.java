/*
Problem: Valid Palindrome
LeetCode: 125
Difficulty: Easy

Approach:
- Use two pointers:
  1. One from the beginning.
  2. One from the end.
- Skip non-alphanumeric characters.
- Compare characters in lowercase form.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/
class Solution {
    public boolean isPalindrome(String s) {
      s=s.toLowerCase().replaceAll["[^A-Za-z0-9]",""];
      int i=0;
      int j=s.length()-1;
      while(i<j){
        if(s.charAt(i)!-s.charAt(j)){
          return false;
        }
        i++;
        j--;
      } 
  return true;
    }
}
