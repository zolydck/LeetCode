class Solution {
    public int findWinningPlayer(int[] skills, int k) {

        int arr_max = 0;
        for(int i : skills){
            arr_max = Math.max(arr_max,i);
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i = 1 ; i < skills.length; i++){
            q.offer(i);
        }
        int maxi = skills[0];
        int ind = 0;
        int wins = 0;
        while(wins!=k){
            //System.out.println(arr_max+"-"+maxi);
            if(maxi == arr_max) return ind;
            if(skills[q.peek()] > maxi){
                q.offer(ind);
                ind = q.peek();
                maxi = skills[q.peek()];
                q.poll();
                wins = 1;
            }
            else{
                int rem = q.poll();
                q.offer(rem);
                wins++;
            }
        }
        return ind;
        
    }
}