package ru.yandex.qa.many_to_one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaTest;
import ru.yandex.qa.model.one_to_many.Car;
import ru.yandex.qa.repository.one_to_many.CarRepository;

import java.util.List;

@Sql("classpath:one_to_many/schema.sql")
public class JpaManyToOneTest extends JpaTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    @Sql("classpath:one_to_many/data.sql")
    void test() {
        List<Car> cars = carRepository.findAll();
        System.out.println(cars);
        System.out.println(cars.size());
    }
}
