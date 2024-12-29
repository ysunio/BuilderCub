package Problems.hard;

import Archieve.Problems.hard.FirstMissingPositive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTest {

    @Test
    public void shouldReturnMissing(){
        FirstMissingPositive fMP = new FirstMissingPositive();
        int missingNumber = fMP.firstMissingPositive(new int[]{1,2,0});
        Assertions.assertEquals(3, missingNumber);
    }

    @Test
    public void shouldReturnMissing2(){
        FirstMissingPositive fMP = new FirstMissingPositive();
        int missingNumber = fMP.firstMissingPositive(new int[]{3,4,-1,1});
        Assertions.assertEquals(2, missingNumber);
    }

    @Test
    public void shouldReturnMissing3(){
        FirstMissingPositive fMP = new FirstMissingPositive();
        int missingNumber = fMP.firstMissingPositive(new int[]{7,8,9,11,12});
        Assertions.assertEquals(1, missingNumber);
    }

    @Test
    public void shouldReturnMissing4(){
        FirstMissingPositive fMP = new FirstMissingPositive();
        int missingNumber = fMP.firstMissingPositive(new int[]{1});
        Assertions.assertEquals(2, missingNumber);
    }

}
