class Solution {
    public boolean isRobotBounded(String instructions) {

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;

        //robot doesn't leave circle if
        int x = 0,y = 0;

        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                x += directions[index][0];
                y += directions[index][1];
            }
            else if (ch == 'L'){
                index = (index + 3) % 4;
            }
            else{
                index = (index+1)%4;
            }
        }
        if((x == 0 && y == 0) || (index != 0)) return true;
        else return false; 
        
    }
}