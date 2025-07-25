class Solution {
    public int totalFruit(int[] fruits) {

        //Max of two different fruits
        //Find the max number of fruits that can be picked.

        int left = 0 , right = 0;
        Map<Integer,Integer>hm = new HashMap<>();

        while(right < fruits.length){
            hm.put(fruits[right],hm.getOrDefault(fruits[right],0)+1);
            if(hm.size() > 2){
                hm.put(fruits[left],hm.get(fruits[left])-1);
                if(hm.get(fruits[left])==0){
                    hm.remove(fruits[left]);
                }
                left++;
            }
            right++;
        }
        return right-left;
        
    }
}