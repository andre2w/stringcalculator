package com.codurance.andre;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String operation) {

        if (operation.length() == 1) {
            return parseInt(operation);
        }

        return 0;
    }
}
