class Solution {
    public int minSteps(String s, String t) {
        int cache1[] = new int[26];
        int cache2[] = new int[26];
        Arrays.fill(cache1, 0);
        Arrays.fill(cache2, 0);
        Set<Character> set = new HashSet<>();
        int len = s.length();    
        for(int i=0; i<len; i++){
            cache1[s.charAt(i)-'a']++;
            cache2[t.charAt(i)-'a']++;
            set.add(s.charAt(i));
        }
        int cnt = 0;
        for(Character ch : set){
            int i = ch-'a';
            // System.out.println(cache1[i] + "-" + cache2[i]);
            if(cache2[i] < cache1[i]){
                cnt = cnt + (cache1[i] - cache2[i]);
            }
        }
        return cnt;
    }
}