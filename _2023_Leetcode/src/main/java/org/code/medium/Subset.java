package org.code.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(new ArrayList<>());

        for (int idx = 0; idx < nums.length; idx++) {
            int finalListSize = finalList.size();
            for (int fIdx = 0; fIdx < finalListSize; fIdx++) {
                List cList = new ArrayList(finalList.get(fIdx));
                cList.add(nums[idx]);
                finalList.add(cList);
            }
        }

        return finalList;
    }
}
