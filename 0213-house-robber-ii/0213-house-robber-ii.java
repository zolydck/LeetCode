class Solution {
    public int rob(int[] nums) {

      if(nums.length == 1) return nums[0];
      return Math.max(findRob(nums,0,nums.length-2),findRob(nums,1,nums.length-1));
        
    }

    public int findRob(int[] nums , int lo, int ho){
        if(ho == lo) return nums[lo];
        int a = nums[lo],b = Math.max(a,nums[lo+1]),temp = 0;
        //ignore the last one
        for(int i = lo+2; i <= ho; i++){
            temp = b;
            b = Math.max(a+nums[i],b);
            a = temp;
        }
        return b;

    }
}