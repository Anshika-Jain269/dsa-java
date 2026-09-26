class Solution {
  int[][][]dp;
  int minProfit;
  int n;
  int MOD=1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            dp=new int[group.length][n+1][minProfit+1];        
        this.n = n;
        this.minProfit = minProfit;
     for(int i=0;i<group.length;i++){
        for(int j=0;j<=n;j++){
            Arrays.fill(dp[i][j],-1);
        }
     }
     return solve(0,0,0,group,profit);
    }
    public int solve(int i,int people,int currentProfit,int[]group,int[]profit){
        if(i==group.length){
            return currentProfit>=minProfit?1:0;
        }
        if(dp[i][people][currentProfit]!=-1){
            return dp[i][people][currentProfit];
        }
        int notake=solve(i+1,people,currentProfit,group,profit);
           int take=0;
          if(people+group[i]<=n){
         take=solve(i+1,people+group[i],Math.min(minProfit,currentProfit+profit[i]),group,profit);
    }
    return dp[i][people][currentProfit]=(take+notake)%MOD;
}
}
