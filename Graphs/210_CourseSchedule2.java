class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            if(!dependencies.containsKey(prerequisites[i][1])){
                dependencies.put(prerequisites[i][1], new ArrayList<>());
            }
            dependencies.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int i = 0; 
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            order[i] = course;
            i++;
            List<Integer> dependency = dependencies.get(course);
            if(dependency == null){
                continue;
            }
            for(Integer depend : dependency){
                indegree[depend]--;
                if(indegree[depend] == 0){
                    queue.offer(depend);
                }
            }
        }
        for(int k=0; k<indegree.length; k++){
            if(indegree[k] != 0){
                return new int[0];
            }
        }
        return order;
    }
}
