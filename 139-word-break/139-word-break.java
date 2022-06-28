public class Solution {
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.cache = new Boolean[s.length()];
        return recur(s, new HashSet<>(wordDict), 0);
    }
    private boolean recur(String s, Set<String> set, int start){
        if(start == s.length()){
            return true;
        }
        if(cache[start] != null){
            return cache[start];
        }
        for(int end=start+1; end <= s.length(); end++){
            if(set.contains(s.substring(start, end)) && recur(s, set, end)){
                return cache[start] = true;
            }
        }
        return cache[start] = false;
    }
}