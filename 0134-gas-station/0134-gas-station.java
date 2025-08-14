class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=0;
        int total_gain = 0 , curr_gain = 0;
        for(int i = 0 ; i < gas.length; i++){
            total_gain +=gas[i] - cost[i];
            curr_gain += gas[i] - cost[i];

            if(curr_gain < 0){
                index = i+1;
                curr_gain = 0;
            }
        }
        return total_gain < 0 ? -1 : index;
    }
}