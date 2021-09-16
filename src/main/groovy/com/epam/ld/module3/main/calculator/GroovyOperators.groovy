package com.epam.ld.module3.main.calculator;

class GroovyOperators {

    private String word

    /**
     * Returns word if it is not null
     *
     * @param word string
     * @return string
     */
    String elvisTernaryOperator(String word) {
        return word ?: "another word"
    }

    /**
     * Returns value of property if it exists
     *
     * @return value of undetermined property
     */
    def safeNavigatorOperator() {
        return this?.word
    }

    /**
     * For test case
     *
     * @param word string
     */
    void setWord(String word) {
        this.word = word
    }

}
