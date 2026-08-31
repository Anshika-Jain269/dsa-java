class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
     int left=Integer.MAX_VALUE; 
     int right=Integer.MIN_VALUE;
     for(int i=0;i<bloomDay.length;i++){
        left=Math.min(left,bloomDay[i]);
        right=Math.max(right,bloomDay[i]);
     }
     if ((long) m * k > bloomDay.length) {
    return -1;
}
     while(left<right){
        int mid=(left+right)/2;
        int flowers=0;
        int boquets=0;
        for(int i:bloomDay){
              if(i<=mid){
                flowers++;
    if(flowers==k){
        boquets++;
        flowers=0;
    }
              }
              else{
                flowers=0;
              }
        }
               if(boquets>=m){
                right=mid;
               }
               else{
                left=mid+1;
               }
     } 
     return left;  
    }
}
