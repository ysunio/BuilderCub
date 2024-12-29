package Archieve.Challenges_2023.Oct;

public class Number_Of_Good_Pairs_1512 {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 1, 1, 1, 3, 4}));
    }
    private static int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int totalCount = 0;
        for(int num : nums){
            totalCount += count[num];
            count[num]++;
        }
        return totalCount;
    }
}
