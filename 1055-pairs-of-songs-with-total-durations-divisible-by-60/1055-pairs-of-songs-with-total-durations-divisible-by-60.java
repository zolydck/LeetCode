class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        //(a+b)%60 == 0
        //(a%60) + ( b%60) % 60 == 0
        //a%60 , b%60 == 0 || ( a % 60) = 60 - (b%60)
        
        //This is known as distributive property for modulo
        int[] remainders = new int[60];
        int count = 0;
        for(int t : time){
            if(t%60 == 0){
                count+=remainders[0];
            }
            else{
                count+= remainders[60 - (t%60)];
            }
            remainders[t%60]++;
        }
        return count;
    }
}