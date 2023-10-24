package _150_Most_Liked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MergeSortedArrayTest {

    @Nested
    class OptimalSolution {
        @Test
        public void shouldReturnSortedArrayOne() {
            int[] A = new int[]{1, 2, 3, 0, 0, 0};
            int[] B = new int[]{2, 5, 6};
            new MergeSortedArray().merge(A, 3, B, 3);
            Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, A);
        }

        @Test
        public void shouldReturnSortedArrayTwo() {
            int[] A = new int[]{1};
            int[] B = new int[]{};
            new MergeSortedArray().merge(A, 1, B, 0);
            Assertions.assertArrayEquals(new int[]{1}, A);
        }

        @Test
        public void shouldReturnSortedArrayThree() {
            int[] A = new int[]{0};
            int[] B = new int[]{1};
            new MergeSortedArray().merge(A, 0, B, 1);
            Assertions.assertArrayEquals(new int[]{1}, A);
        }
    }

    @Nested
    class SolutionWithMemory {
        @Test
        public void shouldReturnSortedArrayOne() {
            int[] A = new int[]{1, 2, 3, 0, 0, 0};
            int[] B = new int[]{2, 5, 6};
            new MergeSortedArray().mergeWithMemory(A, 3, B, 3);
            Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, A);
        }

        @Test
        public void shouldReturnSortedArrayTwo() {
            int[] A = new int[]{1};
            int[] B = new int[]{};
            new MergeSortedArray().mergeWithMemory(A, 1, B, 0);
            Assertions.assertArrayEquals(new int[]{1}, A);
        }

        @Test
        public void shouldReturnSortedArrayThree() {
            int[] A = new int[]{0};
            int[] B = new int[]{1};
            new MergeSortedArray().mergeWithMemory(A, 0, B, 1);
            Assertions.assertArrayEquals(new int[]{1}, A);
        }
    }
}
