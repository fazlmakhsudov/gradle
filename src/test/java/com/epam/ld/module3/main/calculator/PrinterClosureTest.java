package com.epam.ld.module3.main.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterClosureTest {

    @Test
    void doCallCaseOne() {
        String message = "Hello world";
        PrinterClosure printerClosure = new PrinterClosure();

        assertEquals(message, printerClosure.doCall(message));
    }

    @Test
    void doCallCaseTwo() {
        String message = "Test message";
        PrinterClosure printerClosure = new PrinterClosure(message);

        assertEquals(message, printerClosure.doCall());
    }
}