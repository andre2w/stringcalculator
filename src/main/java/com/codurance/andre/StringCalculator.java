package com.codurance.andre;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String operation) {

        if (operation.isEmpty())
            return 0;

        if (operation.length() == 1)
            return parseInt(operation);

        String delimiters = getDelimiters(operation);
        operation = cleanOperationFromDelimiters(operation);

        int[] numbers = Arrays.stream(operation.split(delimiters))
                .mapToInt(Integer::parseInt)
                .toArray();

        validateNumbers(numbers);

        return Arrays.stream(numbers)
                .filter(number -> number <= 1000)
                .sum();
    }

    private void validateNumbers(int[] numbers) {
        if (hasNegative(numbers)) {
            String negativeNumbers = filterNegativeNumbers(numbers);
            throw new IllegalArgumentException(negativeNumbers);
        }
    }

    private String filterNegativeNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> number < 0)
                .mapToObj(String::valueOf)
                .reduce("" ,(number, acumulated) -> acumulated += "," + number);
    }

    private boolean hasNegative(int[] numbers) {
        return Arrays.stream(numbers)
                .anyMatch(number -> number < 0);
    }

    private String cleanOperationFromDelimiters(String operation) {
        if (!hasCustomDelimiter(operation))
            return operation;

        return operation.split("\n", 2)[1];
    }

    private boolean hasCustomDelimiter(String operation) {
        return operation.startsWith("//");
    }

    private String getDelimiters(String operation) {
        String delimiters = "\\n|,";

        if (hasCustomDelimiter(operation)) {
            String customDelimiter = operation.split("\n")[0].substring(2);


            if (customDelimiter.startsWith("[")) {
                customDelimiter = customDelimiter.substring(1, customDelimiter.length() -1);
            }

            delimiters += "|" + customDelimiter;
        }

        return delimiters;
    }
}
