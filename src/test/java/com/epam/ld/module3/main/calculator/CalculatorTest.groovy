import com.epam.ld.module3.main.calculator.EpamCalculator
import com.epam.ld.module3.main.calculator.GroovyOperators
import junit.framework.Test
import junit.textui.TestRunner

import java.nio.charset.StandardCharsets

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotEquals
import static org.junit.jupiter.api.Assertions.assertNull
import static org.junit.jupiter.api.Assertions.assertThrows

class EpamCalculatorTest extends GroovyTestCase {

    private static final String ILLEGAL_SYMBOL_MESSAGE = "Expression contains illegal symbols"
    private static final String expression = "(6*(2+4/2)+6)/3+21";

    void testPow() {
        assertEquals(9, new EpamCalculator().pow(3,2))
    }

    void testPlus() {
        EpamCalculator epamCalculator1 = new EpamCalculator("(6*(2+4/2)+6)/3")
        EpamCalculator epamCalculator2 = new EpamCalculator("21")
        assertEquals(expression, (epamCalculator1 + epamCalculator2).getProperty("expression"))
    }

    void testRunnerWhenPassedProperSymbolsCaseOne() {
        ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8))
        InputStream STD_IN = System.in
        System.setIn(bais)
        EpamCalculator epamCalculator = new EpamCalculator()
        epamCalculator.runner()
        assertEquals(expression + " = 31", epamCalculator.getProperty("expression"))
        System.setIn(STD_IN)
    }

    void testRunnerWhenPassedProperSymbolsCaseTwo() {
        String expression = "3*3+1";
        ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8))
        InputStream STD_IN = System.in
        System.setIn(bais)
        EpamCalculator epamCalculator = new EpamCalculator()
        epamCalculator.runner()
        assertNotEquals(expression + " = 9", epamCalculator.getProperty("expression"))
        System.setIn(STD_IN)
    }

    void testRunnerWhenPassedWrongSymbols() {
        ByteArrayInputStream bais = new ByteArrayInputStream((expression + "d").getBytes(StandardCharsets.UTF_8))
        InputStream STD_IN = System.in
        System.setIn(bais)
        EpamCalculator epamCalculator = new EpamCalculator()
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                { -> epamCalculator.runner() })
        assertEquals(ILLEGAL_SYMBOL_MESSAGE, illegalArgumentException.getMessage())
        System.setIn(STD_IN);
    }
}

class GroovyOperatorsTest extends GroovyTestCase {

    void testElvisTernaryOperatorWhenPassedString() {
        String word = 'word'
        GroovyOperators groovyOperators = new GroovyOperators()
        assertEquals(word, groovyOperators.elvisTernaryOperator(word))
    }

    void testElvisTernaryOperatorWhenPassedNothing() {
        GroovyOperators groovyOperators = new GroovyOperators()
        assertEquals('another word', groovyOperators.elvisTernaryOperator())
    }

    void testSafeNavigatorOperator() {
        String word = "word"
        GroovyOperators groovyOperators = new GroovyOperators()
        assertNull(groovyOperators.safeNavigatorOperator())
        groovyOperators.setProperty(word, word)
        assertNotNull(groovyOperators.safeNavigatorOperator())
        assertEquals(word, groovyOperators.safeNavigatorOperator())
    }
}

class AllTests {
    static Test suite() {
        def allTests = new GroovyTestSuite()
        allTests.addTestSuite(EpamCalculatorTest.class)
        allTests.addTestSuite(GroovyOperatorsTest.class)
        return allTests
    }
}

TestRunner.run(AllTests.suite())