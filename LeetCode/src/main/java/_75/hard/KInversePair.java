package _75.hard;

import java.util.Arrays;

public class KInversePair {
        public int kInversePairs(int n, int k) {
            int[][] dP = new int[1001][1001];
            for(int[] x : dP) Arrays.fill(x, -1);
            return solve(n, k, dP);
        }

        private int solve(int n, int k, int[][] dP){
            if(k <= 0) return k == 0 ? 1 : 0;
            if(dP[n][k] != -1) return dP[n][k];

            int resolved = 0;
            for(int x = 0; x < n; x++){
                resolved += solve(n - 1, k - x, dP);
                resolved %= (Math.pow(10,9) + 7);
            }

            return dP[n][k] = resolved;
        }
}
