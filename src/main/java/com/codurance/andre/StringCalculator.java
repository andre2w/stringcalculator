package com.codurance.andre;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String operation) {

        if (operation.isEmpty())
            return 0;

        if (operation.length() == 1)
            return parseInt(operation);
        

        String[] numbers = operation.split(",");

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
