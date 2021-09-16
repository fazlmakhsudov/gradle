package com.epam.ld.module3.main.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EpamCalculatorTest {

    private static final String ILLEGAL_SYMBOL_MESSAGE = "Expression contains illegal symbols";
    private static final String expression = "(6*(2+4/2)+6)/3+21";

    @Test
    @DisplayName("Test pow with integer basement")
    void testPowInteger() {
        assertEquals(4, new EpamCalculator().pow(2, 2));
    }

    @Test
    @DisplayName("Test pow with double basement")
    void testPowDouble() {
        assertEquals(0.09, new EpamCalculator().pow(0.3, 2));
    }

    @Test
    @DisplayName("Test operator overloading with plus two instance")
    void testPlus() {
        EpamCalculator epamCalculator1 = new EpamCalculator("(6*(2+4/2)+6)/3");
        EpamCalculator epamCalculator2 = new EpamCalculator("21");
        assertEquals(expression, epamCalculator1.testPlus(epamCalculator2).getExpression());
    }

    @Test
    @DisplayName("Test runner when passed proper symbols in expression case one")
    void testRunnerWhenPassedProperSymbolsCaseOne() {
        ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8));
        InputStream STD_IN = System.in;
        System.setIn(bais);
        EpamCalculator epamCalculator = new EpamCalculator();
        epamCalculator.runner();
        assertEquals(expression + " = 31", epamCalculator.getExpression());
        System.setIn(STD_IN);
    }

    @Test
    @DisplayName("Test runner when passed proper symbols in expression case two")
    void testRunnerWhenPassedProperSymbolsCaseTwo() {
        String expression = "3*3+1";
        ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8));
        InputStream STD_IN = System.in;
        System.setIn(bais);
        EpamCalculator epamCalculator = new EpamCalculator();
        epamCalculator.runner();
        assertNotEquals(expression + " = 9", epamCalculator.getExpression());
        System.setIn(STD_IN);
    }

    @Test
    @DisplayName("Test runner when passed wrong symbols in expression")
    void testRunnerWhenPassedWrongSymbols() {
        ByteArrayInputStream bais = new ByteArrayInputStream((expression + "d").getBytes(StandardCharsets.UTF_8));
        InputStream STD_IN = System.in;
        System.setIn(bais);
        EpamCalculator epamCalculator = new EpamCalculator();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                epamCalculator::runner);
        assertEquals(ILLEGAL_SYMBOL_MESSAGE, illegalArgumentException.getMessage());
        System.setIn(STD_IN);
    }
}