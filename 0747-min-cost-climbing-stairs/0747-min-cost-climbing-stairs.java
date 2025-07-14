class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int a = cost[0];
        int b = cost[1];

        int n = cost.length;
        if(n==2) return Math.min(a,b);
        for(int i = 2 ; i <n ; i++){
            int c = cost[i]+Math.min(a,b);
            a = b;
            b = c;
        } 
        return Math.min(a,b);
        
    }
}