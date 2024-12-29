package Archieve._75.medium;

import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] r = new int[temperatures.length];
        for (int idx = temperatures.length - 1; idx >= 0; idx--) {
            int currentElement = temperatures[idx];
            if (stack.isEmpty()) {
                stack.add(idx);
                r[idx] = 0;
            } else {
                if (currentElement < temperatures[stack.peek()]) {
                    stack.push(idx);
                    r[idx] = 1;
                } else {
                    while (!stack.isEmpty() && currentElement >= temperatures[stack.peek()]) stack.pop();
                    if (stack.isEmpty()) r[idx] = 0;
                    else {
                        r[idx] = stack.peek() - idx;
                    }
                    stack.push(idx);
                }
            }
        }
        return r;
    }
}
