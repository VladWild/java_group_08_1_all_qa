package ru.yandex.qa.tech_task_8.manager.impl;

import com.google.gson.Gson;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.manager.http.KVTaskClient;

import java.io.File;

public class HttpTaskManager extends FileBackedTaskManager {

    KVTaskClient kvTaskClient = new KVTaskClient();

    Gson gson = Managers.getGson();


    public HttpTaskManager() {
        super(null);
    }

    public void load() {

    }

    @Override
    protected void save() {
        String json = gson.toJson(tasks);
        kvTaskClient.save("tasks", json);

        //epics
        //subtask

        //history
    }
}
