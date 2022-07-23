class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<>());
            children.add(pid.get(i));
            map.put(ppid.get(i), children);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()){
            Integer parent = queue.remove();
            ans.add(parent);
            if(map.containsKey(parent)){
                List<Integer> children = map.get(parent);
                for(int child : children){
                    queue.add(child);
                }
            }
        }
        return ans;
    }
}