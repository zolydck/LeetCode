class Solution {
    public int maxProfit(int[] prices) {

        //keep track of min price
        int min_sofar = Integer.MAX_VALUE;
        int ans = 0;
        for(int price : prices){
            if(price < min_sofar) min_sofar = price;
            ans = Math.max(price-min_sofar,ans);
        }
        return ans;
        
    }
}