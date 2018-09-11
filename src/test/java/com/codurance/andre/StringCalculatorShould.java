package com.codurance.andre;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void return_zero_for_empty_string() {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void return_number_when_only_one_number_is_passed() {
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    public void return_sum_of_numbers_delimited_by_commas() {
        int result = stringCalculator.add("1,2,3,4");

        assertEquals(10, result);
    }

    @Test
    public void return_sum_of_numbers_delimited_by_line_break() {
        int result = stringCalculator.add("1\n2\n3\n4");

        assertEquals(10, result);
    }

    @Test
    public void return_sum_of_numbers_with_both_delimiters() {
        int result = stringCalculator.add("1,2\n3\n4");

        assertEquals(10, result);
    }

    @Test
    public void accept_custom_delimiters() {
        int result = stringCalculator.add("//;\n1;2;3;4");

        assertEquals(10, result);
    }

    @Test
    public void throw_exception_when_passing_a_negative_number() {

        try {
            stringCalculator.add("0,1,-1,-2");
            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("-2,-1,", exception.getMessage());
        }
    }

    @Test
    public void ignore_numbers_greater_than_a_thousand() {
        int result = stringCalculator.add("2,10000");

        assertEquals(2, result);
    }

    @Test
    public void deal_with_lengthy_delimiters() {
        int result = stringCalculator.add("//[%%%]\n1%%%2%%%3%%%4");

        assertEquals(10, result);
    }

    @Test
    public void deal_with_multiple_custom_delimiters() {
        int result = stringCalculator.add("//[%%%][@@]\n1%%%2@@3@@4");

        assertEquals(10, result);
    }
}
