class Solution {
    public int numTeams(int[] rating) {
		// DP matrix stores the total number of LIS pairs of length 1, 2 and 3 respectively
        int[][] dp = new int[rating.length][4];
        int count = 0;
        dp[0][1] = 1;  // Every element has a 1 length LIS by default
        
        for(int i = 1; i < rating.length; i++) {
            dp[i][1] = 1;
            for(int j = 0; j < i; j++) {
                if(rating[j] < rating[i]) {
                    dp[i][2] += dp[j][1]; // Adding rating[i] makes the one length pairs ending at rating[j], two length pairs 
                    dp[i][3] += dp[j][2]; // Adding rating[i] makes the two length pairs ending at rating[j], three length pairs
                }
            }
			
			// As the number of soldiers are 3
            count += dp[i][3];
        }
		// In reverse order as mentioned in the statement
        dp = new int[rating.length][4];
        dp[dp.length - 1][1] = 1;
        for(int i = dp.length - 2; i >= 0; i--) {
            dp[i][1] = 1;
            for(int j = dp.length - 1; j > i; j--) {
                if(rating[j] < rating[i]) {
                    dp[i][2] += dp[j][1];
                    dp[i][3] += dp[j][2];
                }
            }
            count += dp[i][3];
        }
        return count;
    }
}