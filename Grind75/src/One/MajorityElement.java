package One;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = -1;
        int count = 0;
        for(int x : nums)
            if(x == majority){
                majority = x;
                count++;
            }
            else{
                if(count == 0){
                    majority = x;
                    count++;
                }else count--;
            }
        return majority;
    }
}
