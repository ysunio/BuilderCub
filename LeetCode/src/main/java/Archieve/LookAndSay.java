package Archieve;

public class LookAndSay {
    public static void main(String[] args) {
        System.out.println(nextLookAndSayString("1"));
        System.out.println(nextLookAndSayString("11"));
        System.out.println(nextLookAndSayString("21"));
        System.out.println(nextLookAndSayString("1211"));
        System.out.println(nextLookAndSayString("111221"));
        System.out.println(nextLookAndSayString("312211"));
    }

    private static String nextLookAndSayString(String in){
        StringBuilder rMade = new StringBuilder();

        char lastChar = in.charAt(0);
        int cElementCount = 1;
        int idx = 1;

        while(idx < in.length()){
            if(in.charAt(idx) == lastChar) cElementCount++;
            else {
                rMade.append(cElementCount);
                rMade.append(lastChar);
                cElementCount = 1;
            }
            lastChar = in.charAt(idx);
            idx++;
        }

        if(cElementCount != 0) {
            rMade.append(cElementCount);
            rMade.append(in.charAt(idx - 1));
        }

        return rMade.toString();
    }
}
