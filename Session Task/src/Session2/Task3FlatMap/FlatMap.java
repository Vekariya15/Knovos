package Session2.Task3FlatMap;

          
import java.util.stream.Stream;
import java.util.*;

public class FlatMap {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");


        list.stream()
                .flatMap(str -> Stream.of(str.charAt(2)))
                .forEach(System.out::println);

    }
}
