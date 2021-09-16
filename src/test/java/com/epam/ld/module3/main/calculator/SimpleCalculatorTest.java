package com.epam.ld.module3.main.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void plus() {
        SimpleCalculator simpleCalculator = new SimpleCalculator(1, 3);

        assertEquals(4, simpleCalculator.plus());
        assertEquals(4, simpleCalculator.plus(1,3));
    }
}