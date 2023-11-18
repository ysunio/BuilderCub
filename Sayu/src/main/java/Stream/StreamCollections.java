package Stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamCollections {
    public static void main(String[] args) {
        oddEvenFilter();
        squareMap();
        distinctElements();
        mapToString();
        flatMapWords();
    }

    private static void squareMap() {
        List<Integer> listOfNums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("SQUARE");
        square(listOfNums).forEach(System.out::println);
    }

    private static void flatMapWords() {
        List<String> statements = List.of("Sunil Yadav", "Yadav Sunil", "AWS AMZ");
        statements.stream().flatMap(el -> Stream.of(el.split(" "))).forEach(System.out::println);
    }

    private static void mapToString() {
        List<String> listOfNums = List.of("Sunil", "Yadav", "AWS", "AMZ");
        listOfNums.stream().mapToInt(String::length).forEach(System.out::println);
    }

    private static void distinctElements() {
        List<Integer> listOfNums = List.of(1, 2, 1, 5, 3, 4, 5, 6, 7, 8, 9);
        listOfNums.stream().distinct().toList().forEach(System.out::println);
    }

    private static List<Integer> square(List<Integer> listOfNums) {
        return listOfNums.stream().map(el -> el * el).toList();
    }

    private static void oddEvenFilter() {
        List<Integer> listOfNums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("EVEN");
        even(listOfNums).forEach(System.out::println);
        System.out.println("ODD");
        odd(listOfNums).forEach(System.out::println);
    }

    private static List<Integer> even(List<Integer> listOfNums) {
        return listOfNums.stream().filter(el -> el % 2 == 0).toList();
    }

    private static List<Integer> odd(List<Integer> listOfNums) {
        return listOfNums.stream().filter(el -> el % 2 != 0).toList();
    }
}
