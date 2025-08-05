class Solution {
    public int lengthOfLongestSubstring(String s) {

        //Generate all substrings
        // Longest ? so keep sliding window length constatn ?
        HashMap<Character,Integer>hm = new HashMap<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while(j < s.length()){

            char c = s.charAt(j);

            hm.put(c,hm.getOrDefault(c,0)+1);

            //Iterate through the map ?
            while(hm.get(c) > 1){
                char r = s.charAt(i);
                hm.put(r,hm.get(r)-1);
                i++;
            }
            ans = Math.max(ans,j - i + 1);
            j++;
        }
        return ans;
        
    }
}