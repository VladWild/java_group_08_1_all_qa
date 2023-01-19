package ru.yandex.qa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.qa.config.DbConfig;
import ru.yandex.qa.model.one_to_many.Car;
import ru.yandex.qa.repository.one_to_many.CarRepository;

import java.util.List;

@AutoConfigureDataJpa
@SpringBootTest(classes = DbConfig.class)
public class DataJpaTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    void test() {
        List<Car> all = carRepository.findAll();
        System.out.println(all);
    }

}
