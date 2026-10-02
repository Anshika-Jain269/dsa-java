class Solution {
    public int tribonacci(int n) {
   int tn=0;
    int tn0=0;
    int tn1=1;
    int tn2=1;
    if(n==0)return 0;
    if(n==1 || n==2) return 1;
    for(int i=3;i<=n;i++){
    if(n>2){
      tn=tn0+tn1+tn2;
      tn0 = tn1;
      tn1 = tn2;
      tn2 = tn;
    }       
    }
    return tn;
    }
}
