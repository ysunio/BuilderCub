package Misc;

public class StringCompare {

    public static void main(String[] args) {
        System.out.println("" + compareTwoWordsWithSingleDiff("a", "ab"));
        System.out.println("" + compareTwoWordsWithSingleDiff("a", "ba"));
        System.out.println("" + compareTwoWordsWithSingleDiff("b", "ab"));
        System.out.println("" + compareTwoWordsWithSingleDiff("b", "ba"));
    }

    private static boolean compareTwoWordsWithSingleDiff(String a, String b) {
        int[] range = new int[]{('a' - 1), ('z' + 1)};
        String concatedString = a.concat(b);
        int charXor = 1;
        for (int el : concatedString.toCharArray())
            charXor ^= el;
        return charXor >= range[0] && charXor <= range[1];
    }

}
