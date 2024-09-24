class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //handle edge cases
        if(numerator == 0) return "0";

        if(numerator < 0 ^ denominator < 0){
            sb.append("-");
        }

        long num = Math.abs(Long.valueOf(numerator));
        long denom = Math.abs(Long.valueOf(denominator));

        sb.append(String.valueOf(num/denom));
        long remainder = num % denom;
        if(remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        while(remainder != 0){
            if(hm.containsKey(remainder)){
                sb.insert(hm.get(remainder),"(");
                sb.append(")");
                return sb.toString();
            }
            hm.put(remainder,sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder/denom));
            remainder = remainder%denom;
        }

        return sb.toString();
        
    }
}