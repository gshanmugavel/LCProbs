class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] arr1, int[] arr2) -> {
            return arr1[0] - arr2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, (a,b) -> a[1]-b[1]);
        pq.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int arr[] = pq.peek();
            if(arr[1]<=intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}