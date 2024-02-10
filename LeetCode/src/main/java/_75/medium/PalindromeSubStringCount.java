package _75.medium;

public class PalindromeSubStringCount {
    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();

        int noOfSubString = 0;
        for (int idx = 0; idx < s.length(); idx++) {

            int startIdx = idx;
            int endIdx = idx;

            while (startIdx >= 0 && endIdx < s.length()) {
                char xChar = s.charAt(startIdx);
                char yChar = s.charAt(endIdx);

                if (xChar == (yChar)) {
                    noOfSubString++;
                    startIdx--;
                    endIdx++;
                } else break;
            }

            startIdx = idx;
            endIdx = idx;

            while (startIdx >= 0 && endIdx < s.length() - 1) {
                char xChar = s.charAt(startIdx);
                char yChar = s.charAt(endIdx + 1);

                if (xChar == (yChar)) {
                    noOfSubString++;
                    startIdx--;
                    endIdx++;
                } else break;
            }
        }

        return noOfSubString;
    }
}
