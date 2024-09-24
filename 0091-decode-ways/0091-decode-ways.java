class Solution {
    Map<Integer,Integer>hm;
    public int numDecodings(String s) {
        hm = new HashMap<>();
        return findWays(0,s);
    }

    public int findWays(int index,String s){
        //base cases
        
        if(index == s.length()) {
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }

        if(index == s.length() - 1){
            return 1;
        }
        if(hm.containsKey(index)){
            return hm.get(index);
        }
        int ans = findWays(index+1,s);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
            ans += findWays(index+2,s);
        }
        hm.put(index,ans);
        return ans;
    }
}