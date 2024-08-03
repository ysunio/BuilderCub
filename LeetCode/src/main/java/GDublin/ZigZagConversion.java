package GDublin;

public class ZigZagConversion {

    // https://leetcode.com/problems/zigzag-conversion
    public String convert(String s, int N) {
        // Base case for Row and String
        if (N == 1 || N >= s.length()) return s;

        // Building result for the zig_zag iteration
        StringBuilder strBuilder = new StringBuilder();

        // Iterate over the elements starting from RowNumber
        for (int rowNumber = 0; rowNumber < N; rowNumber++) {

            // Next destination, based on given current index.
            int nextElement = (N * 2) - 2;

            // Power of 2, Difference, to be used for middle element guess.
            int diff = rowNumber * 2;

            // For, start element to all the end in batch of nextElement
            for (int idx = rowNumber; idx < s.length(); idx += nextElement) {
                strBuilder.append(s.charAt(idx));

                // If element is in b/w rows.
                int midElement = (idx + nextElement) - diff;
                if (diff > 0 && diff < nextElement &&  midElement < s.length())
                    strBuilder.append(s.charAt(midElement));
            }
        }

        // Build the string, and return the string.
        return new String(strBuilder);
    }
}