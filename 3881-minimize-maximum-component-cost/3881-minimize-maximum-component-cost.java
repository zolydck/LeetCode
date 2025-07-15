class Solution {
    public int minCost(int n, int[][] edges, int k) {

        //construct the graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        int low = 0 , high = 0 , ans = 0;

        //Now the edges
        for(int[] edge : edges){
            int u = edge[0];
            int v= edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
            high = Math.max(high,w);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(check(graph,mid,k)){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean check(List<List<int[]>> graph, int mid , int k){
        //create a graph which will contain weights only till mid
        //You don't need to store weights as you only have to find the number of connected components
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.size();
        for(int i = 0 ; i < graph.size() ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int [] edge : graph.get(i)){
                int u = edge[0];
                int w = edge[1];
                if(w <= mid){
                    adj.get(i).add(u);
                }
            }
        }

        //Now find the number of connected componenets
        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i = 0; i < n ; i++){
            if(!visited[i]) {
                ++components;
                if(components > k) return false;
                visit(adj,visited,i);
            }
        }
        return true;
    }

    public void visit(List<List<Integer>> adj , boolean[] visited , int i){
        if(visited[i]) return;
        visited[i] = true;
        for(int j : adj.get(i)){
            visit(adj,visited,j);
        }

    }
}