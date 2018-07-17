class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*I think I've written really bad code, using data structures that were not required.
        We can use arrays instead of maps everywhere. And I don't think the initial set is 
        required to get the zero indegree nodes. Try to optimize this code by using primitive
        data structures.*/
        
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Set<Integer> start = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            start.add(i);
        }
        for(int i=0; i<prerequisites.length; i++){
            //Update the indegree map
            if(!indegree.containsKey(prerequisites[i][0])){
                indegree.put(prerequisites[i][0], 0);
            }
            indegree.put(prerequisites[i][0], indegree.get(prerequisites[i][0]) + 1);
            
            //Update the dependency map
            if(dependencies.containsKey(prerequisites[i][1])){
                dependencies.get(prerequisites[i][1]).add(prerequisites[i][0]);
                System.out.println("Dependencies are: " + dependencies.get(prerequisites[i][1]));
            }else{
                dependencies.put(prerequisites[i][1], new ArrayList<>());
                dependencies.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            if(start.contains(prerequisites[i][0])){
                start.remove(prerequisites[i][0]);
            }
        }
        if(start.size() == 0){
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Integer course : start){
            queue.offer(course);
        }
        
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            List<Integer> dependency = dependencies.get(course);
            if(dependency == null){
                indegree.remove(course);
                continue;
            }
            for(Integer c : dependency){
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0){
                    queue.offer(c);
                    indegree.remove(c);
                }
            }
        }
        if(queue.isEmpty() && indegree.size() == 0){
            return true;
        }
        return false;
    }
}
