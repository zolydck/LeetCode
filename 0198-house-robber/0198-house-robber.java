class Solution {
    public int rob(int[] nums) {
        //Recurrence relation is Math.max(find(n-1),nums[i]+rob[n-2])

        //To convert into iterative
        if(nums.length == 1) return nums[0];
        int a = nums[0], b = Math.max(a,nums[1]), temp = 0;
        if(nums.length == 2) return b;
        for(int i = 2;  i < nums.length ; i++){
            temp = b;
            b = Math.max(a+nums[i],b);
            a = temp;
        }
        return b;
        
    }
}