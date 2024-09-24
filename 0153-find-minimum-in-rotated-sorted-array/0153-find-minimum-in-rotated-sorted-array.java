class Solution {
    public int findMin(int[] nums) {

        int lo = 0 , ho = nums.length - 1;
        int ans = nums[0];
        while(lo <= ho){
            int mid = lo + ( ho - lo)/2;

            if(check(mid,nums) == 1){
                ans = nums[mid];
                ho = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
        
    }

    public int check(int index,int[] nums){
        if(nums[index]<nums[0]){
            return 1;
        }
        return 0;
    }
}