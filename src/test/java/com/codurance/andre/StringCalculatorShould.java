package com.codurance.andre;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class StringCalculatorShould {

    @Test
    public void return_zero_for_empty_string() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("");

        assertEquals(result, 0);
    }
}
