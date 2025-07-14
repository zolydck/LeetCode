class Solution {
    public int minCost(String colors, int[] neededTime) {

        //If in a group , find the total sum - max value
        int res = 0 , cur_sum = 0 , max_sum = 0;
    
        for(int i = 0 ; i < colors.length() ; ++i){
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)){
                res += cur_sum - max_sum;
                cur_sum = max_sum = 0;
            }
            cur_sum += neededTime[i];
            max_sum = Math.max(max_sum,neededTime[i]);
        }
        res+= cur_sum - max_sum;

        return res;
        
    }
}