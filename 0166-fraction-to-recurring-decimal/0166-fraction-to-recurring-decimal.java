class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        //Take care of all edge casses

        //1. if numerator = 0
        if(numerator == 0){
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        //2.If numerator or denominator is negative , then ans will be negative
        if(numerator<0 ^ denominator<0){
            ans.append("-");
        }

        //3.we convert both to positive and handle the max negative number
        long num = Math.abs(Long.valueOf(numerator));
        long denom = Math.abs(Long.valueOf(denominator));

        ans.append(String.valueOf(num/denom));
        long remainder = num%denom;

        if(remainder == 0) {
            return ans.toString();
        }
        ans.append(".");
        HashMap<Long,Integer>hm = new HashMap<>();
        while(remainder!=0){

            //if the same number is found
            if(hm.containsKey(remainder)){
                ans.insert(hm.get(remainder),"(");
                ans.append(")");
                return ans.toString();
            }
            //if not then add this number
            hm.put(remainder,ans.length());
            remainder*=10;
            ans.append(String.valueOf(remainder/denom));
            remainder = remainder%denom;
        }
        return ans.toString();
        
    }
}