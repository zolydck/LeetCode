class Solution {
    public int lengthOfLongestSubstring(String s) {

        //Less intuitive solution to sotre last seen index , so that we can skip to it
        HashMap<Character,Integer>hm = new HashMap<>();
        int n = s.length();
        int ans = 0;

        for(int i= 0 , j = 0 ; j < n ; j++){
            if(hm.containsKey(s.charAt(j))){

                //we may have encountered a character , which is out of the current window as we don't delete elements
                //once we cross window'
                i = Math.max(i,hm.get(s.charAt(j)));
            }
            ans = Math.max(ans,j-i+1);
            //j+1 as we can directly start from beginning of next window i.e plan is to avoid the repeating element
            hm.put(s.charAt(j),j+1);
        }
        return ans;
        
    }
}