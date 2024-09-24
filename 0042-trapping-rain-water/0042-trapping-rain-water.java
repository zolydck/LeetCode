class Solution {
    public int trap(int[] height) {

        //we are gonna use one single array
        int l = height.length;
        int[] dp = new int[l];
        int ans = 0;
        int max = Integer.MIN_VALUE;
        dp[l-1] = Integer.MIN_VALUE;
        for(int i = height.length - 2; i >= 0 ; i--){
            dp[i] = Math.max(dp[i+1],height[i+1]);
        }
        for(int i = 0 ; i < l ; i++){
            int s = Math.min(max,dp[i]);
            max = Math.max(height[i],max);
            if(s > height[i]){
                ans += s - height[i];
            }
        }
        return ans;
        
    }
}