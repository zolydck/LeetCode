class Solution {

    int memo[];
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return findAns(0,s);
        
    }

    public int findAns(int index,String s){

       

        //base case - reached the end of string
        if(index == s.length()) return 1;
         if(memo[index] != -1){
            return memo[index];
        }

        if(s.charAt(index) == '0') return 0;

        if(index == s.length() - 1) return 1;

        int ans = findAns(index+1,s);
        ans += (isValid(index,index+2,s) ? findAns(index+2,s) : 0);
        memo[index] = ans;
        return ans;

    }

    public boolean isValid(int i,int j , String s){
        if(Integer.parseInt(s.substring(i,j))> 0 && Integer.parseInt(s.substring(i,j)) <= 26){
            return true;
        }
        return false;
    }
}