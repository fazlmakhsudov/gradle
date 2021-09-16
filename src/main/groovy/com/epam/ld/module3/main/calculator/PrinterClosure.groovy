package com.epam.ld.module3.main.calculator

class PrinterClosure {

    private def closure;

    PrinterClosure(Closure<?> closure) {
        this.closure = closure
    }

    PrinterClosure() {
        this.closure = { message -> return message }
    }

    PrinterClosure(String message) {
        this.closure = { -> return message }
    }

    def doCall() {
        return closure.call()
    }

    def doCall(String message) {
        return closure.call(message)
    }

}
