package ru.yandex.qa.mock_verify;

import org.junit.jupiter.api.*;
import ru.yandex.qa.mock_verify.rest.CbrRestHttpService;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class PaymentServiceTest {
    private CbrRestHttpService cbrRestHttpServiceMock = mock(CbrRestHttpService.class);

    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        paymentService = new PaymentService(cbrRestHttpServiceMock);
    }

    /**
     * 1) Данные, по которым вы хотите проверять работу вашего сервиса
     * 2) Моки нужных сервисов и методов
     * 3) Вызов нужного метода, который вы хотите протестировать и получение результата, если он не void
     * 4) Все нужные вам проверки
     */

    @Test
    @DisplayName("Тест перевода долларов в рубли")
    void processDollarsInRubTest() {
        BigDecimal dollars = new BigDecimal(100);

        when(cbrRestHttpServiceMock.rateDollarInRub()).thenReturn(new BigDecimal(75));

        BigDecimal rub = paymentService.processDollarsInRub(dollars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(new BigDecimal(7500), rub),
                () -> verify(cbrRestHttpServiceMock, times(1)).rateDollarInRub()
        );
    }
}