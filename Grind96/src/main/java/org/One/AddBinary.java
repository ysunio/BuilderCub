package org.One;

public class AddBinary {

    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;

        StringBuilder strBuilder = new StringBuilder();
        boolean hasCarry = false;
        while(aIdx >= 0 && bIdx >= 0){
            char aChar = a.charAt(aIdx);
            char bChar = b.charAt(bIdx);

            if(aChar == '1' && bChar == '1'){
                if(hasCarry){
                    strBuilder.append('1');
                }else{
                    strBuilder.append('0');
                }
                hasCarry = true;
            }else if(aChar == '0' && bChar == '0') {
                if(hasCarry){
                    strBuilder.append('1');
                }else{
                    strBuilder.append('0');
                }
                hasCarry = false;
            }else{
                if(hasCarry){
                    strBuilder.append('0');
                }else{
                    strBuilder.append('1');
                }
            }
            aIdx--; bIdx--;
        }

        while(aIdx >= 0){
            char aChar = a.charAt(aIdx);
            if(hasCarry){
                if(aChar == '1') strBuilder.append('0');
                else{ strBuilder.append('1'); hasCarry=false; }
            }else{
                if(aChar == '1') strBuilder.append('1');
                else{ strBuilder.append('0'); }
            }
            aIdx--;
        }
        System.out.println(strBuilder+" XX ");

        while(bIdx >= 0){
            char aChar = b.charAt(bIdx);
            if(hasCarry){
                if(aChar == '1') strBuilder.append('0');
                else{ strBuilder.append('1'); hasCarry=false; }
            }else{
                if(aChar == '1') strBuilder.append('1');
                else{ strBuilder.append('0'); }
            }
            bIdx--;
        }

        if(hasCarry) strBuilder.append('1');

        return new String(strBuilder.reverse());
    }
}
