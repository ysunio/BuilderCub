package Archieve.Problems.medium;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("Sunil", "Ayushi"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] mem = new int[word1.length()][word2.length()];
        for (int[] x : mem) Arrays.fill(x, -1);
        return minDistance(word1, word2, 0, 0, mem);
    }

    private static int minDistance(String word1, String word2, int idx, int idy, int[][] mem) {
        if (idx == word1.length()) return word2.length() - idy;
        if (idy == word2.length()) return word1.length() - idx;

        int charOne = word1.charAt(idx);
        int charTwo = word2.charAt(idy);

        if (mem[idx][idy] != -1) return mem[idx][idy];
        mem[idx][idy] = Integer.MAX_VALUE;

        if (charOne == charTwo)
            mem[idx][idy] = minDistance(word1, word2, idx + 1, idy + 1, mem); // Equal
        else {
            mem[idx][idy] = 1 + Math.min(
                    minDistance(word1, word2, idx + 1, idy + 1, mem),  // Replace

                    Math.min(
                            minDistance(word1, word2, idx + 1, idy, mem), // Delete
                            minDistance(word1, word2, idx, idy + 1, mem)) // Addition
            );
        }
        return mem[idx][idy];
    }
}
