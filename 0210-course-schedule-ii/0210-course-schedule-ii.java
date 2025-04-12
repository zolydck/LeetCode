class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            //create a adjacency list
        ArrayList<Integer>[] alist = new ArrayList[numCourses];

        //Create indegree array
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(indegree,0);
        for(int[] prereq: prerequisites){
            int course = prereq[0];
            int preCourse = prereq[1];

            if(alist[preCourse] == null){
                alist[preCourse] = new ArrayList<>();
            }
            alist[preCourse].add(course);
            indegree[course]++;
        }   

        //Now the scheduling begins
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
                ans.add(i);
            }
        }  

        //Now the execution begins
        while(!q.isEmpty()){
            int current = q.poll();
            //Now iterate over the adjacency list
            if(alist[current]!=null){
                for(int i : alist[current]){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.offer(i);
                        ans.add(i);
                    }
                }
            }
        }

    return ans.size() == numCourses ? ans.stream().mapToInt(i->i).toArray() : new int[0];
    }
}