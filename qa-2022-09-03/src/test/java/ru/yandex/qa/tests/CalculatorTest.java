package ru.yandex.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Тест суммы")
    void testSum() {
        int sum = calculator.sum(2, 4);
        Assertions.assertEquals(sum, 6);
    }

    @Test
    @DisplayName("Тест вычитания")
    void testDiff() {
        int diff = calculator.diff(8, 4);
        int diff2 = calculator.diff(10, 4);
        int diff3 = calculator.diff(23, 6);
        int diff4 = calculator.diff(45, 7);

        Assertions.assertAll(
                () -> Assertions.assertEquals(diff, 4),
                () -> Assertions.assertEquals(diff2, 6),
                () -> Assertions.assertEquals(diff3, 17),
                () -> Assertions.assertEquals(diff4, 38)
        );
    }

    @ParameterizedTest(name = "{index}. Проверка модуля значения {arguments}")
    @DisplayName("Тест модуля")
    @ValueSource(ints = {8, -8})
    void testAbc(int a) {
        int abc = calculator.abc(a);
        Assertions.assertEquals(abc, 8);
    }

    @ParameterizedTest(name = "{index}. Сумма значений {arguments} должна быть 7")
    @DisplayName("Тест суммы 2")
    @MethodSource("getValuesForSum")
    void testSum2(int[] values) {
        int sum = calculator.sum(values[0], values[1]);
        Assertions.assertEquals(sum, 7);
    }

    private static Stream<int[]> getValuesForSum() {
        return Stream.of(
                new int[]{2, 5},
                new int[]{6, 1},
                new int[]{7, 0},
                new int[]{9, -2}
        );
    }

    @Test
    @DisplayName("Тест недоступности деления")
    void testMultiplication() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> calculator.division(5, 0));
    }
}