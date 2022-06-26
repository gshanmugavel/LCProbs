class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = Integer.MAX_VALUE;
        for(int i=0; i<cards.length; i++){
            int card = cards[i];
            if(map.containsKey(card)){
                int ind = map.get(card);
                count = Math.min(count, i-ind+1);
            }
            map.put(card, i);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}