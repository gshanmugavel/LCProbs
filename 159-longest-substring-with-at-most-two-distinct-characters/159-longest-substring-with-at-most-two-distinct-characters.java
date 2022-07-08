class Solution {
    Deque<Character> dq = new LinkedList<>();
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    private void cleanDQ(){
        while(!dq.isEmpty() && map.get(dq.getFirst()) > 0){
            Character ch = dq.getFirst();
            map.put(ch, map.get(ch)-1);
            dq.removeFirst();
            if(map.get(ch) == 0){
               count--;
               map.remove(ch); 
               break;
            }
        }
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        for(Character ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                count++;
                // System.out.println(ch + " " + count);
            }
            map.put(ch, map.getOrDefault(ch,0)+1);
            dq.addLast(ch);
            if(count > 2){
                cleanDQ();
            }
            max = Math.max(max, dq.size());
        }
        return max;
    }
}