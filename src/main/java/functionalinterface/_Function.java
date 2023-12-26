package functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
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
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return ++number;
    }
}
