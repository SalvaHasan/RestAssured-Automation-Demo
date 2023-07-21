package com.studentframework.tests;

import groovyjarjarpicocli.CommandLine;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestResultLogger.class)
public class DataProviderExample {

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 7 })
    void checkEvenNumber(int number) {
        assertEquals(0, number % 2,
                "Supplied number is not an even number");
    }

    @ParameterizedTest
    @ValueSource(strings = { "a1", "b--=p" })
    void checkAlphanumeric(String word) {
        StringUtils StringUtils = null;
        assertTrue(StringUtils.isAlphanumeric(word),
                "Supplied word is not alpha-numeric");
    }

    @ParameterizedTest
    @NullSource
    void checkNull(String value) {
        assertEquals(null, value);
    }

    @ParameterizedTest
    @EmptySource
    void checkEmpty(String value) {
        assertEquals("", value);
    }

    @ParameterizedTest
    @CsvSource({ "2, 8",
            "3, 3"})
    void addNumbers(int num1, int num2) {
        assertEquals(10, num1 + num2);
    }
}
