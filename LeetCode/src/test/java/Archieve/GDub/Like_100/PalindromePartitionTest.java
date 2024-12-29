package Archieve.GDub.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitionTest {

    @Test
    void partition() {
        PalindromePartition palindromePartition = new PalindromePartition();
        List<List<String>> rResult = palindromePartition.partition("abbab");
        Assertions.assertEquals(4, rResult.size());
        Assertions.assertArrayEquals(List.of("a","b","b","a","b").toArray(), rResult.get(0).toArray());
        Assertions.assertArrayEquals(List.of("a","b","bab").toArray(), rResult.get(1).toArray());
        Assertions.assertArrayEquals(List.of("a","bb","a","b").toArray(), rResult.get(2).toArray());
        Assertions.assertArrayEquals(List.of("abba","b").toArray(), rResult.get(3).toArray());
    }
}