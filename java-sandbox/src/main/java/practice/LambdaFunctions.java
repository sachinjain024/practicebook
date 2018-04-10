package practice;

import java.util.function.Supplier;

public class LambdaFunctions {
    private static int counter = 0;

    public static void main(String args[]) {
        displayNumbers();
    }

    private static void display(Supplier<Integer> supplier) {
        counter++;
        System.out.println(supplier.get());
    }

    private static void displayNumbers() {
        int localCounter = 10;

        display(() -> {
            // Note that this block gets executed later one
            // Note that even local variables are accessible
            return counter + localCounter + 10;
        });

        display(() -> counter + 100);
    }
}
