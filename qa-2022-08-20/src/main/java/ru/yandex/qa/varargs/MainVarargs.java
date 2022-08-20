package ru.yandex.qa.varargs;

public class MainVarargs {

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log();
        logger.log("1", "5", "7");
        logger.log("create person id %d age %d", 1, 24);
    }
}
