package com.buildercub.strings;

public class Atoi {
        public int myAtoi(String s) {

            // Preflight check for Boundary cases.
            s = s.trim();
            if(s.isEmpty()) return 0;

            int idx = 0;
            int sign = 1;

            // Forwarding index, if sign is found at 0 and keeping sign value
            if(s.charAt(0) == '-') {
                sign = -1; idx++;
            }else if(s.charAt(0) == '+'){
                idx++;
            }

            // Iterating over each value
            long madeNumber = 0;
            while(idx < s.length()){
                char cChar = s.charAt(idx);

                // If char is out of range, we return the build number
                if(cChar < '0' || cChar > '9') return (int) madeNumber;

                // Making number with 10th place, and adding value
                madeNumber = madeNumber * 10 + ((long) sign * (cChar - '0'));

                // If made number is out of INT range, return MIN / MAX.
                if(madeNumber <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if(madeNumber >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                idx++;
            }

            return (int) madeNumber;
        }
}
