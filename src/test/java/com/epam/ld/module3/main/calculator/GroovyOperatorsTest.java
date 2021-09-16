package com.epam.ld.module3.main.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GroovyOperatorsTest {

    private static final String WORD = "word";
    private static final String ANOTHER_WORD = "another word";

    @Test
    void testElvisTernaryOperatorWhenPassedString() {
        GroovyOperators groovyOperators = new GroovyOperators();
        assertEquals(WORD, groovyOperators.elvisTernaryOperator(WORD));
    }

    @Test
    void testElvisTernaryOperatorWhenPassedNothing() {
        GroovyOperators groovyOperators = new GroovyOperators();
        assertEquals(ANOTHER_WORD, groovyOperators.elvisTernaryOperator(null));
    }

    @Test
    void testSafeNavigatorOperator() {
        GroovyOperators groovyOperators = new GroovyOperators();
        assertNull(groovyOperators.safeNavigatorOperator());
        groovyOperators.setWord(WORD);
        assertNotNull(groovyOperators.safeNavigatorOperator());
        assertEquals(WORD, groovyOperators.safeNavigatorOperator());
    }

}