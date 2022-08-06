package ru.yandex.qa.varargs;

public class VarargsMain {

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("data1", "data2");
        logger.log("create person id %d age %d", 1, 28);
    }
}
