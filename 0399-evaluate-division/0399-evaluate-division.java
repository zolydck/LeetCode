class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        

        Map<String,Map<String,Double>> graph = buildGraph(equations,values);
        double[] results = new double[queries.size()];
        int i = 0;
        for(var query : queries){
            String start = query.get(0);
            String end = query.get(1);
            if(!graph.containsKey(start) || !graph.containsKey(end)){
                results[i++] = -1.0;
            }
            else{
                results[i++] = findBfs(start,end,graph);
                }
        }
        return results;
    }

    public Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){

        //To build a graph , iterate over the equations
        Map<String,Map<String,Double>> g = new HashMap<>();
        int i = 0;

        for(List<String> equation : equations){
            String num = equation.get(0);
            String denom = equation.get(1);
            double v = values[i];
            g.putIfAbsent(num,new HashMap<>());
            g.putIfAbsent(denom,new HashMap<>());
            g.get(num).put(denom,v);
            g.get(denom).put(num,1.0/v);

            i++;

        }
        return g;

    }

    public Double findBfs(String start , String end , Map<String,Map<String,Double>> graph){

        Set<String> visited = new HashSet<>();
        Queue<Pair<String,Double>>q = new LinkedList<>();

        q.add(new Pair<>(start,1.0));
        while(!q.isEmpty()){
            Pair<String,Double> pair = q.poll();
            String node = pair.getKey();
            Double value = pair.getValue();
            //System.out.println("value is "+value + node + end);
            if(node.equals(end)){
                return value;
            }

            visited.add(node);
            //Iterate over the map
            for(var entry : graph.get(node).entrySet()){

                String neighbourNode = entry.getKey();
                Double neighbourValue = entry.getValue();

                if(!visited.contains(neighbourNode)){
                    q.offer(new Pair<>(neighbourNode,neighbourValue * value));
                }

            }

        }
        return -1.0;



    }
}