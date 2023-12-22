package _75.easy;

public class MergeAlternatively {

    public String mergeAlternatelyWithCharArray(String A, String B) {
        char[] sBuilder = new char[A.length() + B.length()];

        int builderIdx = 0;
        int aLen = 0;
        int bLen = 0;

        boolean zig = true;
        while(aLen < A.length() && bLen < B.length()){
            if(zig) sBuilder[builderIdx++] = (char) A.charAt(aLen++);
            else sBuilder[builderIdx++] = (char) B.charAt(bLen++);
            zig = !zig;
        }

        while(aLen < A.length()) sBuilder[builderIdx++] = (char) A.charAt(aLen++);
        while(bLen < B.length()) sBuilder[builderIdx++] = (char) B.charAt(bLen++);

        return new String(sBuilder);
    }

    public String mergeAlternatelyWithBuilder(String A, String B) {
        StringBuilder sBuilder = new StringBuilder();
        int aLen = 0;
        int bLen = 0;

        boolean zig = true;
        while(aLen < A.length() && bLen < B.length()){
            if(zig) sBuilder.append(A.charAt(aLen++));
            else sBuilder.append(B.charAt(bLen++));
            zig = !zig;
        }

        sBuilder.append(A.substring(aLen));
        sBuilder.append(B.substring(bLen));

        return new String(sBuilder);
    }


}
