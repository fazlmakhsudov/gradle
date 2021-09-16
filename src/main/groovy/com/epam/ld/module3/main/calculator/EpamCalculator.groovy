package com.epam.ld.module3.main.calculator

import java.util.regex.Matcher
import java.util.regex.Pattern

class EpamCalculator {

    private static final String ILLEGAL_SYMBOL_MESSAGE = "Expression contains illegal symbols"
    private def multiplicationAndDivisionRegex = "([)][*/+-])?([\\d]+)([/*])([\\d]+)([*/+-][(])?"
    private def additionAndSubtractionRegex = "([)][*/+-])?([\\d]+)([-+])([\\d]+)([*/+-][(])?"
    private def bracketsRegex = "([(])([\\d]+)([)])"
    private def VALID_SYMBOL_REGEX = "[\\d/+(*)-]+";
    private def expression

    /**
     * Constructor
     *
     * @param expression expression
     */
    EpamCalculator(expression) {
        this.expression = expression
    }

    /**
     * Constructor
     */
    EpamCalculator() {
    }

    /**
     * Obtain expression from console
     *
     * @return expression
     */
    static String obtainExpression() {
        print 'Type expression: '
        String expression = System.in.newReader().readLine()
        println "It was typed expression: $expression"
        return expression
    }

    /**
     * Runner
     * It includes Closure instance
     */
    void runner() {
        expression = obtainExpression()
        expression = "${expression} = ${operationRunner(expression)}".toString()
        println "Answer: ${expression}"
    }

    /**
     * Overloading operator plus
     *
     * @param other another instance
     * @return new instance
     */
    def plus(EpamCalculator other) {
        return new EpamCalculator(this.expression + '+' + other.expression);
    }

    /**
     * Pow operation (overloaded for integer)
     *
     * @param basement integer
     * @param extent integer
     * @return basement in extent
     */
    def pow(int basement, int extent) {
        return basement ** extent;
    }

    /**
     * Pow operation (overloaded for double)
     *
     * @param basement double
     * @param extent double
     * @return basement in extent
     */
    def pow(double basement, double extent) {
        return basement ** extent;
    }

    /**
     * For writing test case
     */
    def getExpression() {
        return expression;
    }

    /**
     * For writing test case
     *
     * @param other instance
     * @return joined instance
     */
     EpamCalculator testPlus(EpamCalculator other) {
        return this + other
    }

    private String operationRunner(String expression) {
        String tempExpression = basicRunner(new String(expression))
        println tempExpression + " phaze 1"
        tempExpression = removeBrackets(tempExpression)
        println tempExpression + " phaze 2"
        if (!tempExpression.matches("\\d+")) {
            tempExpression = operationRunner(tempExpression);
        }
        return tempExpression
    }

    private String calculateMultiplicationAndDivision(String tempExpression) {
        Pattern pattern = Pattern.compile(multiplicationAndDivisionRegex)
        Matcher matcher = pattern.matcher(tempExpression)
        while (matcher.find()) {
            if (matcher.group(1) != null || matcher.group(5) != null) {
                continue
            }
            def a = matcher.group(2) as Integer
            def b = matcher.group(4) as Integer
            def tempResult
            println "a = $a  b = $b"
            if (matcher.group(3) == '/') {
                tempResult = a / b
                println "Temporary result is ${tempResult}"
            } else {
                tempResult = a * b
                println "Temporary result is ${tempResult}"
            }
            tempExpression = tempExpression.substring(0, matcher.start()) + (tempResult as String) + tempExpression.substring(matcher.end())
            matcher.reset(tempExpression)
        }
        return tempExpression
    }

    private String calculateAdditionAndSubtraction(String tempExpression) {
        Pattern pattern = Pattern.compile(additionAndSubtractionRegex)
        Matcher matcher = pattern.matcher(tempExpression)
        while (matcher.find()) {
            if (matcher.group(1) != null || matcher.group(5) != null) {
                continue
            }
            def a = matcher.group(2) as Integer
            def b = matcher.group(4) as Integer
            def tempResult
            println "a = $a  b = $b"
            if (matcher.group(3) == '+') {
                tempResult = a + b
                println "Temporary result is ${tempResult}"
            } else {
                tempResult = a - b
                println "Temporary result is ${tempResult}"
            }
            tempExpression = tempExpression.substring(0, matcher.start()) + (tempResult as String) + tempExpression.substring(matcher.end())
            matcher.reset(tempExpression)
        }
        return tempExpression
    }

    private String basicRunner(String tempExpression) {
        checkForIllegalSymbols(tempExpression)
        tempExpression = calculateMultiplicationAndDivision(tempExpression)
        return calculateAdditionAndSubtraction(tempExpression)
    }

    private void checkForIllegalSymbols(String tempExpression) {
        if (!tempExpression.matches(VALID_SYMBOL_REGEX)) {
            throw new IllegalArgumentException(ILLEGAL_SYMBOL_MESSAGE)
        }
    }

    private String removeBrackets(String tempExpression) {
        checkForIllegalSymbols(tempExpression)
        Pattern pattern = Pattern.compile(bracketsRegex)
        tempExpression = new String(tempExpression)
        Matcher matcher = pattern.matcher(tempExpression)
        while (matcher.find()) {
            tempExpression = tempExpression.substring(0, matcher.start()) + matcher.group(2) + tempExpression.substring(matcher.end())
            matcher.reset(tempExpression)
        }
        return tempExpression
    }

}
