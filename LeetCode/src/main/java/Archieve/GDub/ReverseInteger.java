package Archieve.GDub;

public class ReverseInteger {
        public int reverse(int x) {

            // Store value into long, such that we get larger space
            long reverseValue = 0L;

            // Reverse the value here
            while(x != 0){
                reverseValue *= 10;
                reverseValue += x % 10;
                x /= 10;
            }

            // Validate if result build is in INT range.
            if(reverseValue > Integer.MAX_VALUE || reverseValue < Integer.MIN_VALUE) return 0;
            return (int) reverseValue;
        }
}
