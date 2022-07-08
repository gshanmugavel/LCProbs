class Solution {
  Deque<Integer> dq = new LinkedList<>();
  int [] nums;

  public void cleanDQ(int i, int k) {
    if(!dq.isEmpty() &&  i - dq.getFirst() == k){
        dq.removeFirst();
    }
    while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
        dq.removeLast();
    }
    dq.addLast(i);
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;
    
    this.nums = nums;
    for(int i=0; i<k; i++){
        cleanDQ(i, k);
    }
    int ans[] = new int[n-k+1];
    ans[0] = nums[dq.getFirst()];
    for(int i=k; i<n; i++){
        cleanDQ(i, k);
        ans[i-k+1] = nums[dq.getFirst()];
    }
    return ans;
  }
}