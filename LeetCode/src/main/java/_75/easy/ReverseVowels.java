package _75.easy;

import java.util.List;

public class ReverseVowels {
    public String reverse(String str) {
        char[] cStr = str.toCharArray();

        int lItr = 0;
        int rItr = cStr.length - 1;

        while(lItr < rItr){
            char lChar = cStr[lItr];
            char rChar = cStr[rItr];
            if(isVowels(lChar) && isVowels(rChar)){
                char swapChar = cStr[lItr];
                cStr[lItr] = cStr[rItr];
                cStr[rItr] = swapChar;
                lItr++; rItr--;
            }else if(!isVowels(lChar)) lItr++;
            else if(!isVowels(rChar)) rItr--;
            else {
                lItr++; rItr--;
            }
        }
        return new String(cStr);
    }

    private boolean isVowels(char v){
        return List.of('a','e','i','o','u').contains(Character.toLowerCase(v));
    }
}
