package GDublin.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    @Test
    void generateParenthesis() {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> stringList = generateParenthesis.generateParenthesis(3);
        Assertions.assertEquals(5, stringList.size());
        Assertions.assertArrayEquals(List.of("((()))","(()())","(())()","()(())","()()()").toArray(), stringList.toArray());
    }
}