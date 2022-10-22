package ru.yandex.qa.mock_verify;

import ru.yandex.qa.mock_verify.rest.CbrRestHttpService;

import java.math.BigDecimal;

public class PaymentService {

    private final CbrRestHttpService cbrRestHttpService;

    public PaymentService(CbrRestHttpService cbrRestHttpService) {
        this.cbrRestHttpService = cbrRestHttpService;
    }

    public BigDecimal processDollarsInRub(BigDecimal dollars) {
        if (dollars == null) {
            //do something
        }
        BigDecimal rate = cbrRestHttpService.rateDollarInRub();
        return dollars.multiply(rate);
    }
}
