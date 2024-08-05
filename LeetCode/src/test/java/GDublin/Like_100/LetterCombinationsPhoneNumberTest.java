package GDublin.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsPhoneNumberTest {

    @Test
    void letterCombinations() {
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        List<String> lStr = letterCombinationsPhoneNumber.letterCombinations("23");
        Assertions.assertEquals(9, lStr.size());
        Assertions.assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"), lStr);
    }
}