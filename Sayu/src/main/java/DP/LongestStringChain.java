package DP;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(solve(strArray));

        String[] strArray2 = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(solve(strArray2));

        String[] strArray3 = new String[]{"bdca", "bda", "ca", "dca", "a"};
        System.out.println(solve(strArray3));

    }

    private static int solve(String[] str) {
        Arrays.sort(str, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(str));
        int maxSum = 1;
        for (int idx = 0; idx < str.length; idx++) {
            maxSum = Math.max(maxSum, maxChain(str, idx, new int[str.length]));
        }
        return maxSum;
    }

    private static int maxChain(String[] strArray, int idx, int[] dp) {
        if (idx + 1 >= strArray.length) return 0;
        if (dp[idx] != 0) return dp[idx];

        String currentString = strArray[idx];
        String nextString = strArray[idx + 1];

        if (isValidString(currentString, nextString)) {
            System.out.printf(currentString + " >> " + nextString + " >> ");
            dp[idx] = 1 + maxChain(strArray, idx + 1, dp);
        } else {
            dp[idx] = maxChain(strArray, idx + 1, dp);
        }
        System.out.println();

        return dp[idx];
    }

    private static boolean isValidString(String a, String b) {
        if (a.length() != b.length() - 1) return false;
        for (int idx = 0; idx < b.length(); idx++) {
            String bCopy = b.substring(0, idx) + b.substring(idx + 1);
            if (bCopy.equals(a)) return true;
        }
        return false;
    }
}


/*


//        int maxPath = 1;
//        for (int itr = idx + 1; itr < strArray.length; itr++) {
//            String nextString = strArray[itr];
//
//            if (isValidString(currentString, nextString)) {
//                System.out.println(currentString + " && " + nextString);
//                dp[idx] = Math.max(maxPath, 1 + maxChain(strArray, idx + 1, dp));
//            }
//        }

//        dp[idx]--;

 */