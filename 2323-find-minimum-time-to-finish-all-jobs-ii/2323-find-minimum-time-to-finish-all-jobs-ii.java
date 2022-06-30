class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(workers);
        Arrays.sort(jobs);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<workers.length; i++){
            int cnt=0;
            if(jobs[i]>workers[i]){
                int tmpQ = jobs[i]/workers[i];
                int tmpR = jobs[i]%workers[i];
                cnt += (tmpQ + (tmpR != 0 ? 1 : tmpR));
            }else{
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}