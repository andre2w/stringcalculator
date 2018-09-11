package com.codurance.andre;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void return_zero_for_empty_string() {
        int result = stringCalculator.add("");

        assertEquals(result, 0);
    }

    @Test
    public void return_number_when_only_one_number_is_passed() {
        int result = stringCalculator.add("1");

        assertEquals(result, 1);
    }

    @Test
    public void returm_sum_of_numbers_delimited_by_commas() {
        int result = stringCalculator.add("1,2,3,4");

        assertEquals(result, 10);
    }
}
