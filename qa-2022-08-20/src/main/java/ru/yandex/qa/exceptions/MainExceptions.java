package ru.yandex.qa.exceptions;

/**
 * Сказать про то, почему есть такое деление на проверяемые и не проверяемые
 * Если бы все были проверяемыми, то вся программа была бы в try-catch-finally
 */
public class MainExceptions {

    public static void main(String[] args) {
        /*
        //под конец
        try {
            method();
        } catch (MyUncheckException myUncheckException) {
            System.out.println(myUncheckException);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException);
        }
        */

        method();
        throw new MyUncheckException();
    }

    private static void method() {
        try {
            throw new MyCheckException();
        } catch (MyCheckException e) {
            throw new MyUncheckException();
        }
    }

    public static class MyCheckException extends Exception {

    }

    public static class MyUncheckException extends RuntimeException {

    }
}
