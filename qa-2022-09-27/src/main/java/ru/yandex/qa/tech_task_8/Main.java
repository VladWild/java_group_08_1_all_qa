package ru.yandex.qa.tech_task_8;

import ru.yandex.qa.tech_task_8.manager.http.KVTaskClient;

public class Main {

    public static void main(String[] args) {
        KVTaskClient kvTaskClient = new KVTaskClient();
        kvTaskClient.put("1", "данные");
    }
}
