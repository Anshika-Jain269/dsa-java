/*
Problem: Group Anagrams
LeetCode: 49
Difficulty: Medium

Approach:
- Sort each string.
- Use the sorted string as a key in HashMap.
- Group all strings having the same sorted form.
- Return all groups.

Time Complexity: O(n * k log k)
Space Complexity: O(n)

Author: Anshika Jain
*/

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) { 
  Map<String,List<String>>map=new HashMap<>();
      for(String s:strs){
        char[] arr=s.toCharArray();
       Arrays.sort(arr);
        String key=new String(arr);
        if(!map.containsKey(key)){
          map.put(key,new ArrayList<>());
        }
        map.get(key).add(s);
      }
      return new ArrayList(map.values());
    }
}
