class Solution {
    String str;
    int len;
    Integer cache[];
    private int recur(int ind){
        if(ind > len){
            return 0;
        }
        if(ind == len){
            return 1;
        }
        if(cache[ind] != null){
            return cache[ind];
        }
        if(str.substring(ind, ind+1).equals("0")){
            return 0;
        }
        if(ind == len-1){
            return 1;
        }
        int one = recur(ind+1);
        int sec = 0;
        if(Integer.valueOf(str.substring(ind, ind+2)) <= 26){
            sec = recur(ind+2);
        }
        return cache[ind] = one+sec;
    }
    public int numDecodings(String s) {
        this.str = s;
        this.len = s.length();
        cache = new Integer[this.len];
        return recur(0);
    }
}