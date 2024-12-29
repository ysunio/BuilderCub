package _75.medium;

import Archieve._75.medium.FindKthElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKthElementTest {

    @Test
    void findKthLargest() {
        FindKthElement findKthElement = new FindKthElement();
        assertEquals(5, findKthElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthElement.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}