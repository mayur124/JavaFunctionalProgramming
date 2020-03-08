package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        /*
        *  Function is a Functional interface which takes two arguments -> one input argument and one output argument
        *  Functional interface has only one abstract method and through lambda expression we can create an instance of functional interface
        */
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        System.out.println("// Increment by one, then multiply by ten");
        System.out.println(incrementByOneFunction.andThen(multiplyByTenFunction).apply(1));

        /*
        * BiFunction is also a Functional Interface
        */
        int incrementAndMultiplyByNumber = incrementByOneAndMultiplyByTenFunction.apply(1,100);
        System.out.println(incrementAndMultiplyByNumber);
    }

    // incrementByOneFunction, multiplyByTenFunction is instances of functional interface "Function" which is being accessed using lambda expressions

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByTenFunction = (numToAdd, numToMultiply) -> (numToAdd + 1) * numToMultiply;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
