class Solution {
    public int minReorder(int n, int[][] connections) {

        //Create a undirectional adjacency list
        List<List<Integer>> al = new ArrayList<>();
        for(int i =0 ; i < n ; i++){
            al.add(new ArrayList<>());
        }

        //populate the edges
        for(int[] connection : connections){
            al.get(connection[0]).add(connection[1]);
            al.get(connection[1]).add(-connection[0]);
        }

        //return the dfs
        return dfs(al,new boolean[n],0);
        
    }

    public int dfs(List<List<Integer>> al, boolean[] visited, int from){

        //Mark the node as visited
        visited[from] = true;
        int change = 0;
        //Iterate over the adjacency list of from
        for(var c : al.get(from)){
            if(!visited[Math.abs(c)]){
                change += dfs(al,visited,Math.abs(c)) + (c > 0 ? 1 : 0);
            }
        }
        return change;

    }
}