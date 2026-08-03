/*
Approach:
- Backtracking
- Try every candidate starting from the current index.
- Reuse the same candidate by calling recursion with the same index.
- If sum == target, store the current combination.
- If sum > target, stop exploring that path.
- Time Complexity: Exponential
- Space Complexity: O(target) (recursion stack + current list)
*/
import java.util.List;
import java.util.ArrayList;
class Solution {
    int[]candidates;
    List<List<Integer>>result=new ArrayList<>(); 
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        this.candidates=candidates;
         check(0,0,new ArrayList<>());
         return result;
        }
    public void check(int index,int previous_sum,List<Integer>current_list){
     
            for(int i=index;i<candidates.length;i++){
            int chosen=candidates[i];
            int sum=previous_sum+chosen;
           if(sum==target){
            current_list.add(chosen);
           result.add(new ArrayList<>(current_list));
           current_list.remove(current_list.size()-1);
          
    }
    else if(sum<target){
       current_list.add(chosen);
       check(i,sum,current_list);
       current_list.remove(current_list.size()-1);
    }
    else{
        return;
           }
}
}
}
