class Solution {
    public int findTheWinner(int n, int k) {
        int startIndex = 0,remIndex = 0;
        List<Integer>circle = new LinkedList<>();

        for(int i = 1; i <= n ; i++){
            circle.add(i);
        }
        
        //while a friend remains
        while(circle.size() > 1){
            remIndex = (startIndex + k - 1) % circle.size();
            circle.remove(remIndex);
            startIndex = remIndex;
        }
        return circle.get(0);
    }
}