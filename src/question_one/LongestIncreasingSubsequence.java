package question_one;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] V) {
        int n = V.length;
        int[] dp = new int[n];
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (V[j] < V[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static int findLIS(int[] V) {
        int n = V.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lisRecursive(V, i, memo));
        }

        return maxLen;
    }

    private static int lisRecursive(int[] V, int i, int[] memo) {
        if (memo[i] != -1)
            return memo[i];

        int max = 1;

        for (int j = 0; j < i; j++) {
            if (V[j] < V[i]) {
                max = Math.max(max, lisRecursive(V, j, memo) + 1);
            }
        }

        memo[i] = max;
        return max;
    }
}
