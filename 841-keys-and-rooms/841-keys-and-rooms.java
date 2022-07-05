class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while(!queue.isEmpty()){
            Integer room = queue.poll();
            if(!vis[room]){
                vis[room] = true;
                count++;
            }else{
                continue;
            }
            for(Integer key : rooms.get(room)){
                queue.offer(key);
            }
        }
        return count == n;
    }
}