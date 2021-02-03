import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;


// a * b + c * d

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var array = new ArrayList<Integer>();

        IntStream.range(0, 4).forEach(i ->
            array.add(scanner.nextInt())
        );
        System.out.println(array);
    }
}
