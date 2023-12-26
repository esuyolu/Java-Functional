package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneThanMultiplyByTen = incrementByOneFunction
               .andThen(multiplyByTenFunction);

        int result = addByOneThanMultiplyByTen.apply(1);
        System.out.println(result);

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyByBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return ++number;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByBiFunction =
            (numberToIncrementByOne, numToMultiplyBy) -> (numberToIncrementByOne + 1) * numToMultiplyBy;

    static int incrementByOneAndMultiply(int numberToIncrementByOne, int numToMultiplyBy) {
        return (numberToIncrementByOne + 1) * numToMultiplyBy;
    }
}
