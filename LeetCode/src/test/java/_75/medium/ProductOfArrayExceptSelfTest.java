package _75.medium;

import Archieve._75.medium.ProductOfArrayExceptSelf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @Test
    void productExceptSelf() {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        assertArrayEquals(new int[]{24,12,8,6}, productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{0,0,9,0,0}, productOfArrayExceptSelf.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}