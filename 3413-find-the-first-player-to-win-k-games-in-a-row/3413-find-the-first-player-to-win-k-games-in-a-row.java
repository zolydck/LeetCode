class Solution {
    public int findWinningPlayer(int[] skills, int k) {

        int wins = 0;
        int j = 0;
        for(int i = 1 ; i < skills.length ; i++){
            if(skills[i]>skills[j]){
                j = i;
                wins = 1;
            }
            else{
                wins++;
            }
            if(wins == k) break;
        }
        return j;
        
    }
}