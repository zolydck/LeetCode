class Solution {
    public int countSubstrings(String s) {

        int ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            ans += findlen(s,i,i);
            ans += findlen(s,i,i+1);
        }
        return ans;
        
    }

    int findlen(String s, int l0, int h0){

        int res = 0;
        while(l0 >= 0 && h0 < s.length()){
            if(s.charAt(l0) != s.charAt(h0)){
                break;
            }
            l0--;
            h0++;
            res++;
        }
        return res;
    }
}