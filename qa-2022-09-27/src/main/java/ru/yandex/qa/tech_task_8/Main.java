package ru.yandex.qa.tech_task_8;

import com.google.gson.Gson;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.manager.TaskManager;
import ru.yandex.qa.tech_task_8.manager.http.KVTaskClient;
import ru.yandex.qa.tech_task_8.task.Task;

public class Main {

    public static void main(String[] args) {
        KVTaskClient kvTaskClient = new KVTaskClient();

        Task task = new Task(1);

        Gson gson = Managers.getGson();
        String json = gson.toJson(task);

        kvTaskClient.save("tasks", json);
        System.out.println(kvTaskClient);
    }
}
