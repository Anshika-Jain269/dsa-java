/*
LeetCode 40 - Combination Sum II

Approach:
1. Sort the array.
2. Use backtracking.
3. Skip duplicates using:
   if(i > index && candidates[i] == candidates[i-1]) continue;
4. Move to i+1 because each element can be used only once.

Time Complexity: O(2^N)
Space Complexity: O(N) (excluding output)
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    int[] candidates;
    int target;
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
             Arrays.sort(candidates);
             this.candidates=candidates;
             this.target=target;
             check(0,0,new ArrayList<>());
             return result;
    }
    public void check(int index,int previous_sum,List<Integer>current_list){
        for(int i=index;i<candidates.length;i++){
            int chosen=candidates[i];
            int sum=previous_sum+chosen;
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
         if(sum==target){
            current_list.add(chosen);
            result.add(new ArrayList<>(current_list));
            current_list.remove(current_list.size()-1);
            break;
         }
           else if(sum<target){
             current_list.add(chosen);
             check(i+1,sum,current_list);
             current_list.remove(current_list.size()-1);
           }
           else{
            break;
           }
        }
    }
}
