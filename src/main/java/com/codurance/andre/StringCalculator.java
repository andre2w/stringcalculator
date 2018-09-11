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

        return Arrays.stream(operation.split(delimiters))
                .mapToInt(Integer::parseInt)
                .sum();
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
            String customDelimiter = operation.split("\n")[0];
            delimiters += "|" + customDelimiter.substring(2);
        }
        return delimiters;
    }
}
