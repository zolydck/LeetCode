class Solution {
    public int characterReplacement(String s, int k) {

        //check for substrings greater than k
        int[] hm1 = new int[26];
        for(int i= 0 ; i < k ; i++){
            hm1[s.charAt(i) - 'A']++;
        }

        //Now a function to keep finding the max frequency and ensuring that right-left+1 <= k + max_freq
        int left = 0 , right = k;
        while(right < s.length()){

            hm1[s.charAt(right)-'A']++;
            if(!check(hm1,k,right,left)){
                hm1[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public boolean check(int[] hm1,int k, int right,int left){
        int max_freq = 0;
        for(int i = 0 ; i < 26 ; i++){
            max_freq = Math.max(max_freq,hm1[i]);
        }
        if(right-left+1 <= k + max_freq) return true;
        return false;
    }
}